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

### Extracting Symbols

On Windows, the below snippet runs the `symstore.exe` utility and extracts symbols for your deployed game files. Symstore can be found as part of the Windows Debugging Tools: https://docs.microsoft.com/en-us/windows/win32/debug/using-symstore

```groovy
builder.extractSymbols()
    .symstore('C:\\Program Files (x86)\\Windows Kits\\10\\Debuggers\\x64\\symstore.exe')
    .source(buildResult.deployPath)
    .destination(env.WORKSPACE + '/Symbols')
    .product('Your Product Name')
    .run(this);
```

The symbols can then be uploaded somewhere, for example Amazon S3:

```groovy
withAWS(region: 'eu-west-1', credentials: 'MyAWSCredentials') {
    s3Upload(bucket: 'symbols', workingDir: env.WORKSPACE + '/Symbols', includePathPattern: '**/*')
}
```
