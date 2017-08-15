import com.github.javaparser.JavaParser
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import groovy.io.FileType
import groovy.util.logging.Slf4j

import java.nio.file.Path

@Slf4j
class Main {
    static void main(String[] args) {
        assert args.length == 1
        final path = args[0]
        processSourcesInDirectory(path)
    }

    static void processSourcesInDirectory(String directory) {
        final basePath = new File(directory)
        assert basePath.directory
        basePath.eachFileRecurse(FileType.FILES) { file ->
            if (file.name =~ /\.java$/) {
                final relativePath = basePath.toPath().relativize(file.toPath())
                processSource(file, relativePath)
            }
        }
    }

    static void processSource(File source, Path relativePath) {
        final compilationUnit = JavaParser.parse(source)
        compilationUnit.getChildNodesByType(ClassOrInterfaceDeclaration).each { classOrInterfaceDeclaration ->
            final classString = classOrInterfaceDeclaration.nameAsString
            classOrInterfaceDeclaration.fields.findAll { fieldDeclaration ->
                // Exclude static field
                !fieldDeclaration.static
            }.each { fieldDeclaration ->
                // Print as CSV line
                final lineNumber = fieldDeclaration.begin.get().line
                final fieldString = fieldDeclaration.toString().split(/[\r\n]+/).join(' ')
                println("${relativePath},L${lineNumber},${classString},${fieldString}")
            }
        }
    }
}
