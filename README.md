# Extract Fields in Java Sources

This is an example of parsing Java sources and extracting fields using [Java Parser](https://github.com/javaparser/javaparser).


## Getting Started

Just run the task.

```bash
./gradlew run -PbasePath=directory
```

For instance, result on sources in [Effective Java Examples](https://github.com/marhan/effective-java-examples) may following:

```
$ ./gradlew run -PbasePath=../effective-java-examples
:compileJava NO-SOURCE
:compileGroovy
:processResources NO-SOURCE
:classes
:run
src\main\java\org\effectivejava\examples\chapter02\item02\builder\NutritionFacts.java,L5,NutritionFacts,private final int servingSize;
src\main\java\org\effectivejava\examples\chapter02\item02\builder\NutritionFacts.java,L6,NutritionFacts,private final int servings;
src\main\java\org\effectivejava\examples\chapter02\item02\builder\NutritionFacts.java,L7,NutritionFacts,private final int calories;
src\main\java\org\effectivejava\examples\chapter02\item02\builder\NutritionFacts.java,L8,NutritionFacts,private final int fat;
src\main\java\org\effectivejava\examples\chapter02\item02\builder\NutritionFacts.java,L9,NutritionFacts,private final int sodium;
src\main\java\org\effectivejava\examples\chapter02\item02\builder\NutritionFacts.java,L10,NutritionFacts,private final int carbohydrate;
src\main\java\org\effectivejava\examples\chapter02\item02\builder\NutritionFacts.java,L14,Builder,// Required parameters private final int servingSize;
src\main\java\org\effectivejava\examples\chapter02\item02\builder\NutritionFacts.java,L15,Builder,private final int servings;
src\main\java\org\effectivejava\examples\chapter02\item02\builder\NutritionFacts.java,L18,Builder,// Optional parameters - initialized to default values private int calories = 0;
src\main\java\org\effectivejava\examples\chapter02\item02\builder\NutritionFacts.java,L19,Builder,private int fat = 0;
src\main\java\org\effectivejava\examples\chapter02\item02\builder\NutritionFacts.java,L20,Builder,private int carbohydrate = 0;
src\main\java\org\effectivejava\examples\chapter02\item02\builder\NutritionFacts.java,L21,Builder,private int sodium = 0;
src\main\java\org\effectivejava\examples\chapter02\item02\javabeans\NutritionFacts.java,L6,NutritionFacts,// Parameters initialized to default values (if any) // Required; no default value private int servingSize = -1;

...snip...
```


## How works

See [Main.groovy](src/main/groovy/Main.groovy) for details.
