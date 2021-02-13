# Jenkins.UnrealEngine.Builder
Groovy scripts for use in Jenkinsfiles to build Unreal Engine 4

## Usage

### Loading the Library

You can either:
* Add this repo as a Git submodule (pick the `v1` branch)
* Copy `UnrealEngine.groovy` into your repository
* Use the below snippet to checkout the repo every build:
```groovy
def builder;
dir ('Builder') {
    git(url: 'https://github.com/alanedwardes/Jenkins.UnrealEngine.Builder.git', branch: 'v1');
    builder = load('UnrealEngine.groovy');
}
```

### Cooking your Game

The below snippet runs Unreal Engine 4 build tools via the command line to build, cook and package your game, similar to doing so in the Unreal Engine Editor UI:

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
    
echo(buildResult.deployPath); // Prints "Path/To/WindowsNoEditor"
```

### Building your Game

The below snippet builds the editor binaries for your chosen platform using Unreal Build Tool:

```groovy
builder.build()
    .enginePath('Path/To/UnrealEngine')
    .target('MyGameEditor')
    .clientConfig('Development')
    .targetPlatform('Win64')
    .useUBTMakefiles(false)
    .allowFASTBuild(false)
    .allowHotReloadFromIDE(false)
    .project('Path/To/MyProject.uproject')
    .run(this);
```

### Building Lighting

The below snippet runs lightmass for the specified map, and rebuilds reflection captures:

```groovy
builder.resavePackages()
    .enginePath('Path/To/UnrealEngine')
    .targetPlatform('Win64')
    .project('Path/To/MyProject.uproject')
    .projectOnly(true)
    .mapsOnly(true)
    .quality('Preview')
    .buildLighting(true)
    .buildReflectionCaptures(true)
    .allowCommandletRendering(true)
    .addMap('/Game/Maps/MyMap1')
    .addMap('/Game/Maps/MyMap2')
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
    s3Upload(bucket: 'symbols', workingDir: env.WORKSPACE + '/Symbols', includePathPattern: '**/*');
}
```
