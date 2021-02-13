# Jenkins.UnrealEngine.Builder
Groovy scripts for use in Jenkinsfiles to build Unreal Engine 4

## Loading the Library

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

## Versioning
If pulling this library in your build, always use a versioned branch, do not use `main`. The versioned branches are guaranteed to be updated with forwards-compatible changes (fixes and features).
* `v1` Initial version of tools

## Usage Examples

1. [Cooking your Game](#build-cook-run)
2. [Building your Game](#build)
3. [Building Lighting](#resave-packages)
4. [Extracting Symbols](#extracting-symbols)

### Build Cook Run

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

| Option | Required | Type | Description |
| - | - | - | - |
| enginePath | Yes | String | The path to Unreal Engine |
| verbose | - | Boolean | The amount of detail to write to the log |
| veryVerbose | - | Boolean | The amount of detail to write to the log |
| noPerforce | - | Boolean | Disables Perforce functionality (default if not run on a build machine) |
| logFileName | - | String | Specifies the path to a log file to write. Note that the default mode (eg. building, generating project files) will create a log file by default if this not specified |
| logTimestamps | - | Boolean | Whether to include timestamps in the log |
| logFromMsBuild | - | Boolean | Whether to format messages in MsBuild format |
| writeProgressMarkup | - | Boolean | Whether to write progress markup in a format that can be parsed by other programs |
| noMutex | - | Boolean | Whether to ignore the mutex |
| waitMutex | - | Boolean | Whether to wait for the mutex rather than aborting immediately |
| remoteIni | - | String | |
| clientConfig | Yes | String | Debug, Shipping, Test, Development, DebugGame |
| targetPlatform | Yes | String | Sets platforms to build for non-dedicated servers |
| project | Yes | String | Package the project for the target platform |
| scriptsForProject | - | String | - |
| archiveDirectory | - | String | Directory to archive the client to |
| shouldCook | - | Boolean | Determines if the build is going to use cooked data |
| shouldStage | - | Boolean | Put this build in a stage directory |
| shouldArchive | - | Boolean | Put this build in an archive directory |
| forDistribution | - | Boolean | Package for distribution of the project |
| shouldBuild | - | Boolean | If build step should be executed |
| shouldPackage | - | Boolean | Package the project for the target platform |
| skipCookingEditorContent | - | Boolean | Skips content under /Engine/Editor when cooking |
| usePak | - | Boolean | Should use packfiles |
| executable | - | String | The Unreal Engine 4 executable to use |
| noCompileEditor | - | Boolean | - |

### Build

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

| Option | Required | Type | Description |
| - | - | - | - |
| enginePath | Yes | String | The path to Unreal Engine |
| verbose | - | Boolean | The amount of detail to write to the log |
| veryVerbose | - | Boolean | The amount of detail to write to the log |
| noPerforce | - | Boolean | Disables Perforce functionality (default if not run on a build machine) |
| logFileName | - | String | Specifies the path to a log file to write. Note that the default mode (eg. building, generating project files) will create a log file by default if this not specified |
| logTimestamps | - | Boolean | Whether to include timestamps in the log |
| logFromMsBuild | - | Boolean | Whether to format messages in MsBuild format |
| writeProgressMarkup | - | Boolean | Whether to write progress markup in a format that can be parsed by other programs |
| noMutex | - | Boolean | Whether to ignore the mutex |
| waitMutex | - | Boolean | Whether to wait for the mutex rather than aborting immediately |
| remoteIni | - | String | |
| clientConfig | Yes | String | Debug, Shipping, Test, Development, DebugGame |
| targetPlatform | Yes | String | Sets platforms to build for non-dedicated servers |
| project | Yes | String | Package the project for the target platform |
| usePrecompiled | - | Boolean | Use existing static libraries for all engine modules in this target |
| allowXGE | - | Boolean | Whether XGE may be used |
| allowFASTBuild | - | Boolean | Whether FASTBuild may be used |
| useUBTMakefiles | - | Boolean | Enables support for very fast iterative builds by caching target data |
| maxParallelActions | - | Integer | Number of actions that can be executed in parallel. If 0 then code will pick a default based on the number of cores available. Only applies to the ParallelExecutor |
| forceHeaderGeneration | - | Boolean | If true, force header regeneration. Intended for the build machine |
| doNotBuildUHT | - | Boolean | If true, do not build UHT, assume it is already built |
| failIfGeneratedCodeChanges | - | Boolean | If true, fail if any of the generated header files is out of date |
| allowHotReloadFromIDE | - | Boolean | True if hot-reload from IDE is allowed |
| skipRulesCompile | - | Boolean | |

### Resave Packages

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

:warning: If your Windows build agent is running as a service user, this will fail when trying to initialise the GPU. The Jenkins agent must be running interactively (e.g. started by a logged in user and visible on the desktop).

| Option | Required | Type | Description |
| - | - | - | - |
| enginePath | Yes | String | The path to Unreal Engine |
| targetPlatform | Yes | String | Sets platforms to build for non-dedicated servers |
| project | Yes | String | Package the project for the target platform |
| skipMaps | - | Boolean | - |
| mapsOnly | - | Boolean | - |
| projectOnly | - | Boolean | - |
| skipDeveloperFolders | - | Boolean | - |
| onlyDeveloperFolders | - | Boolean | - |
| fixupRedirects | - | Boolean | This option will filter the package list and only save packages that are redirectors, or that reference redirectors |
| buildLighting | - | Boolean | Determine if we are building lighting for the map packages on the pass |
| buildReflectionCaptures | - | Boolean | Determine if we are building reflection captures for the map packages on the pass |
| buildTextureStreamingForAll | - | Boolean | Rebuilds texture streaming data for all packages, rather than just maps |
| buildTextureStreaming | - | Boolean | Determine if we are building texture streaming data for the map packages on the pass |
| onlyMaterials | - | Boolean | Only process packages containing materials |
| buildNavigationData | - | Boolean | Determine if we are building navigation data for the map packages on the pass |
| filterByCollection | - | String | Check for filtering packages by collection |
| buildHLOD | - | Boolean | Determine if we are building HLOD data for the map packages on the pass. |
| allowCommandletRendering | - | Boolean | - |
| quality | - | String | Lighting quality, defaults to Production. |
| firstPackage | - | String | Allow for an option to restart at a given package name (in case it dies during a run, etc) |
| packageSubString | - | String | - |
| addMap | - | String | Adds the specified map to the build (if no maps specified, the default is all) |

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

| Option | Required | Type | Description |
| - | - | - | - |
| symstore | Yes | String | The path to symstore.exe |
| source | Yes | String | The path to your deployed game, for example the "WindowsNoEditor" folder |
| destination | Yes | String | The path to output the symbols |
| product | Yes | String | The name of the product to identify these symbols (see symstore.exe documentation) |
