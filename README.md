# Jenkins.UnrealEngine.Builder
Groovy scripts for use in Jenkinsfiles to build Unreal Engine 4

## Usage

### Loading the Library

You can either:
* Add this repo as a Git submodule
* Copy `UnrealEngine.groovy` into your repository
* Use the below snippet to checkout the repo every build:
```groovy
def builder;
dir ('Builder') {
    git(url: 'https://github.com/alanedwardes/Jenkins.UnrealEngine.Builder.git', branch: 'main');
    builder = load('UnrealEngine.groovy')
}
```

### Building your Game

The below snippet runs Unreal Engine 4 build tools via the command line to build, cook and package your game:

```groovy
def buildResult = builder.buildCookRun()
  .enginePath('Path/To/UnrealEngine')
  .noPerforce(true)
  .verbose(true)
  .project('Path/To/MyProject.uproject')
  .shouldCook(true)
  .shouldStage(true)
  .shouldArchive(true)
  .forDistribution(true)
  .shouldBuild(true)
  .shouldPackage(true)
  .skipCookingEditorContent(true)
  .targetPlatform('Win64')
  .clientConfig('Shipping')
  .usePak(true)
  .archiveDirectory('Path/To/Archive)
  .run(this);
```
