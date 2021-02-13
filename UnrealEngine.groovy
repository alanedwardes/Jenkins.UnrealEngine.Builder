class UnrealBuildToolGlobalOptions {
    /**
    * The path to unreal engine
    */
    public UnrealBuildToolGlobalOptions enginePath(String enginePath) { this.enginePath = enginePath; return this; }
    public String enginePath;
    /**
    * The amount of detail to write to the log
    */
    public UnrealBuildToolGlobalOptions verbose(Boolean verbose) { this.verbose = verbose; return this; }
    public Boolean verbose;
    /**
    * The amount of detail to write to the log
    */
    public UnrealBuildToolGlobalOptions veryVerbose(Boolean veryVerbose) { this.veryVerbose = veryVerbose; return this; }
    public Boolean veryVerbose;
    /**
    * Disables Perforce functionality (default if not run on a build machine)
    */
    public UnrealBuildToolGlobalOptions noPerforce(Boolean noPerforce) { this.noPerforce = noPerforce; return this; }
    public Boolean noPerforce;
    /**
    * Specifies the path to a log file to write. Note that the default mode (eg. building, generating project files) will create a log file by default if this not specified.
    */
    public UnrealBuildToolGlobalOptions logFileName(String logFileName) { this.logFileName = logFileName; return this; }
    public String logFileName;
    /**
    * Whether to include timestamps in the log
    */
    public UnrealBuildToolGlobalOptions logTimestamps(Boolean logTimestamps) { this.logTimestamps = logTimestamps; return this; }
    public Boolean logTimestamps;
    /**
    * Whether to format messages in MsBuild format
    */
    public UnrealBuildToolGlobalOptions logFromMsBuild(Boolean logFromMsBuild) { this.logFromMsBuild = logFromMsBuild; return this; }
    public Boolean logFromMsBuild;
    /**
    * Whether to write progress markup in a format that can be parsed by other programs
    */
    public UnrealBuildToolGlobalOptions writeProgressMarkup(Boolean writeProgressMarkup) { this.writeProgressMarkup = writeProgressMarkup; return this; }
    public Boolean writeProgressMarkup;
    /**
    * Whether to ignore the mutex
    */
    public UnrealBuildToolGlobalOptions noMutex(Boolean noMutex) { this.noMutex = noMutex; return this; }
    public Boolean noMutex;
    /**
    * Whether to wait for the mutex rather than aborting immediately
    */
    public UnrealBuildToolGlobalOptions waitMutex(Boolean waitMutex) { this.waitMutex = waitMutex; return this; }
    public Boolean waitMutex;
    /**
    * Whether to wait for the mutex rather than aborting immediately
    */
    public UnrealBuildToolGlobalOptions remoteIni(String remoteIni) { this.remoteIni = remoteIni; return this; }
    public String remoteIni;

    /**
    * Add the parameters to the specified list.
    */
    public def addParameters(List<String> parameters) {
        Ensure.isSet(this.enginePath, 'enginePath');

        if (this.verbose) parameters.add('-Verbose');
        if (this.veryVerbose) parameters.add('-VeryVerbose');
        if (this.noPerforce) parameters.add('-NoP4');
        if (this.logFileName) parameters.add('-Log=' + logFileName);
        if (this.logTimestamps) parameters.add('-Timestamps');
        if (this.logFromMsBuild) parameters.add('-FromMsBuild');
        if (this.writeProgressMarkup) parameters.add('-Progress');
        if (this.noMutex) parameters.add('-NoMutex');
        if (this.waitMutex) parameters.add('-WaitMutex');
        if (this.remoteIni) parameters.add('-RemoteIni');
    }
}

class UnrealBuildCookRunResult {
    public String deployPath;
}

class UnrealBuildCookRunTool extends UnrealBuildToolGlobalOptions {
    /**
    * List of client configurations:
       * Debug
       * Shipping
       * Test
       * Development
       * DebugGame
    */
    public UnrealBuildCookRunTool clientConfig(String clientConfig) { this.clientConfig = clientConfig; return this; }
    public String clientConfig;
    /**
    * Sets platforms to build for non-dedicated servers
    */
    public UnrealBuildCookRunTool targetPlatform(String targetPlatform) { this.targetPlatform = targetPlatform; return this; }
    public String targetPlatform;
    /**
    * Package the project for the target platform
    */
    public UnrealBuildCookRunTool project(String project) { this.project = project; return this; }
    public String project;

    public UnrealBuildCookRunTool scriptsForProject(String scriptsForProject) { this.scriptsForProject = scriptsForProject; return this; }
    public String scriptsForProject;
    /**
    * Directory to archive the client to
    */
    public UnrealBuildCookRunTool archiveDirectory(String archiveDirectory) { this.archiveDirectory = archiveDirectory; return this; }
    public String archiveDirectory;
    /**
    * Determines if the build is going to use cooked data
    */
    public UnrealBuildCookRunTool shouldCook(Boolean shouldCook) { this.shouldCook = shouldCook; return this; }
    public Boolean shouldCook;
    /**
    * Put this build in a stage directory
    */
    public UnrealBuildCookRunTool shouldStage(Boolean shouldStage) { this.shouldStage = shouldStage; return this; }
    public Boolean shouldStage;
    /**
    * Put this build in an archive directory
    */
    public UnrealBuildCookRunTool shouldArchive(Boolean shouldArchive) { this.shouldArchive = shouldArchive; return this; }
    public Boolean shouldArchive;
    /**
    * Package for distribution of the project
    */
    public UnrealBuildCookRunTool forDistribution(Boolean forDistribution) { this.forDistribution = forDistribution; return this; }
    public Boolean forDistribution;
    /**
    * If build step should be executed
    */
    public UnrealBuildCookRunTool shouldBuild(Boolean shouldBuild) { this.shouldBuild = shouldBuild; return this; }
    public Boolean shouldBuild;
    /**
    * Package the project for the target platform
    */
    public UnrealBuildCookRunTool shouldPackage(Boolean shouldPackage) { this.shouldPackage = shouldPackage; return this; }
    public Boolean shouldPackage;
    /**
    * Skips content under /Engine/Editor when cooking
    */
    public UnrealBuildCookRunTool skipCookingEditorContent(Boolean skipCookingEditorContent) { this.skipCookingEditorContent = skipCookingEditorContent; return this; }
    public Boolean skipCookingEditorContent;
    /**
    * Should use packfiles
    */
    public UnrealBuildCookRunTool usePak(Boolean usePak) { this.usePak = usePak; return this; }
    public Boolean usePak;
    /**
    * The Unreal Engine 4 executable to use
    */
    public UnrealBuildCookRunTool executable(String executable) { this.executable = executable; return this; }
    public String executable;

    public UnrealBuildCookRunTool noCompileEditor(String noCompileEditor) { this.noCompileEditor = noCompileEditor; return this; }
    public String noCompileEditor;

    /**
    * Add the parameters to the specified list.
    */
    public def addParameters(List<String> parameters) {
        Ensure.isSet(this.clientConfig, 'clientConfig');
        Ensure.isSet(this.targetPlatform, 'targetPlatform');
        Ensure.isSet(this.project, 'project');

        if (this.clientConfig) parameters.add('-ClientConfig=' + clientConfig);
        if (this.targetPlatform) parameters.add('-TargetPlatform=' + targetPlatform);
        if (this.project) parameters.add('-Project=' + project);
        if (this.scriptsForProject) parameters.add('-ScriptsForProject=' + scriptsForProject);
        if (this.archiveDirectory) parameters.add('-ArchiveDirectory=' + archiveDirectory);
        if (this.shouldCook) parameters.add('-Cook');
        if (this.shouldStage) parameters.add('-Stage');
        if (this.shouldArchive) parameters.add('-Archive');
        if (this.forDistribution) parameters.add('-Distribution');
        if (this.shouldBuild) parameters.add('-Build');
        if (this.shouldPackage) parameters.add('-Package');
        if (this.skipCookingEditorContent) parameters.add('-SkipCookingEditorContent');
        if (this.usePak) parameters.add('-Pak');
        if (this.executable) parameters.add('-UE4exe=' + executable);
        if (this.noCompileEditor) parameters.add('-NoCompileEditor');

        super.addParameters(parameters);
    }

    /**
    * Run the command.
    */
    public def UnrealBuildCookRunResult run(WorkflowScript context) {
        String buildScript = context.isUnix() ? '/Engine/Build/BatchFiles/RunUAT.sh' : '\\Engine\\Build\\BatchFiles\\RunUAT.bat';

        List<String> parameters = [];
        this.addParameters(parameters);

        String command = this.enginePath + buildScript + ' BuildCookRun ' + parameters.join(' ');

        if (context.isUnix()) {
            context.sh(command);
        } else {
            context.bat(command);
        }

        String noEditorPath = (this.targetPlatform.startsWith('Win') ? 'Windows' : this.targetPlatform) + 'NoEditor';

        UnrealBuildCookRunResult result = new UnrealBuildCookRunResult();
        result.deployPath = this.archiveDirectory + '/' + noEditorPath;
        return result;
    }
}

UnrealBuildCookRunTool buildCookRun() {
    return new UnrealBuildCookRunTool();
}

class SymbolExtractorTool {
    public SymbolExtractorTool symstore(String symstore) { this.symstore = symstore; return this; }
    public String symstore;

    public SymbolExtractorTool source(String source) { this.source = source; return this; }
    public String source;

    public SymbolExtractorTool destination(String destination) { this.destination = destination; return this; }
    public String destination;

    public SymbolExtractorTool product(String product) { this.product = product; return this; }
    public String product;

    public def run(WorkflowScript context) {
        Ensure.isSet(this.symstore, 'symstore');
        Ensure.isSet(this.source, 'source');
        Ensure.isSet(this.destination, 'destination');
        Ensure.isSet(this.product, 'product');

        context.dir (this.source) {
            for (def symbolFile : context.findFiles(glob: '**/*.*')) {
                if (symbolFile.name.endsWith('exe') || symbolFile.name.endsWith('pdb')) {
                    context.bat('"' + this.symstore + '" add /f "' + symbolFile.path + '" /s "' + this.destination + '" /t "' + this.product + '"');
                }
            }
        }
    }
}

SymbolExtractorTool extractSymbols() {
    return new SymbolExtractorTool();
}

class UnrealBuildTool extends UnrealBuildToolGlobalOptions {
    /**
    * Sets the target to build
    */
    public UnrealBuildTool target(String target) { this.target = target; return this; }
    public String target;
    /**
    * List of client configurations:
       * Debug
       * Shipping
       * Test
       * Development
       * DebugGame
    */
    public UnrealBuildTool clientConfig(String clientConfig) { this.clientConfig = clientConfig; return this; }
    public String clientConfig;
    /**
    * Sets platforms to build for non-dedicated servers
    */
    public UnrealBuildTool targetPlatform(String targetPlatform) { this.targetPlatform = targetPlatform; return this; }
    public String targetPlatform;
    /**
    * Package the project for the target platform
    */
    public UnrealBuildTool project(String project) { this.project = project; return this; }
    public String project;
    /**
    * Use existing static libraries for all engine modules in this target.
    */
    public UnrealBuildTool usePrecompiled(Boolean usePrecompiled) { this.usePrecompiled = usePrecompiled; return this; }
    public Boolean usePrecompiled = false;
    /**
    * Whether XGE may be used.
    */
    public UnrealBuildTool allowXGE(Boolean allowXGE) { this.allowXGE = allowXGE; return this; }
    public Boolean allowXGE = true;
    /**
    * Whether FASTBuild may be used.
    */
    public UnrealBuildTool allowFASTBuild(Boolean allowFASTBuild) { this.allowFASTBuild = allowFASTBuild; return this; }
    public Boolean allowFASTBuild = true;
    /**
    * Enables support for very fast iterative builds by caching target data. Turning this on causes Unreal Build Tool to emit
    * 'UBT Makefiles' for targets when they are built the first time. Subsequent builds will load these Makefiles and begin
    * outdatedness checking and build invocation very quickly. The caveat is that if source files are added or removed to
    * the project, UBT will need to gather information about those in order for your build to complete successfully. Currently,
    * you must run the project file generator after adding/removing source files to tell UBT to re-gather this information.
    * 
    * Events that can invalidate the 'UBT Makefile':  
    *		- Adding/removing .cpp files
    *		- Adding/removing .h files with UObjects
    *		- Adding new UObject types to a file that did not previously have any
    *		- Changing global build settings (most settings in this file qualify)
    *		- Changed code that affects how Unreal Header Tool works
    *	
    *	You can force regeneration of the 'UBT Makefile' by passing the '-gather' argument, or simply regenerating project files.
    *
    *	This also enables the fast include file dependency scanning and caching system that allows Unreal Build Tool to detect out 
    * of date dependencies very quickly. When enabled, a deep C++ include graph does not have to be generated, and instead,
    * we only scan and cache indirect includes for after a dependent build product was already found to be out of date. During the
    * next build, we will load those cached indirect includes and check for outdatedness.
    */
    public UnrealBuildTool noUBTMakefiles(Boolean noUBTMakefiles) { this.noUBTMakefiles = noUBTMakefiles; return this; }
    public Boolean useUBTMakefiles = true;
    /**
    * Number of actions that can be executed in parallel. If 0 then code will pick a default based on the number of cores available. Only applies to the ParallelExecutor
    */
    public UnrealBuildTool maxParallelActions(Integer maxParallelActions) { this.maxParallelActions = maxParallelActions; return this; }
    public Integer maxParallelActions = 0;
    /**
    * If true, force header regeneration. Intended for the build machine.
    */
    public UnrealBuildTool forceHeaderGeneration(Boolean forceHeaderGeneration) { this.forceHeaderGeneration = forceHeaderGeneration; return this; }
    public Boolean forceHeaderGeneration = false;
    /**
    * If true, do not build UHT, assume it is already built.
    */
    public UnrealBuildTool doNotBuildUHT(Boolean doNotBuildUHT) { this.doNotBuildUHT = doNotBuildUHT; return this; }
    public Boolean doNotBuildUHT = false;
    /**
    * If true, fail if any of the generated header files is out of date.
    */
    public UnrealBuildTool failIfGeneratedCodeChanges(Boolean failIfGeneratedCodeChanges) { this.failIfGeneratedCodeChanges = failIfGeneratedCodeChanges; return this; }
    public Boolean failIfGeneratedCodeChanges = false;
    /**
    * True if hot-reload from IDE is allowed.
    */
    public UnrealBuildTool allowHotReloadFromIDE(Boolean allowHotReloadFromIDE) { this.allowHotReloadFromIDE = allowHotReloadFromIDE; return this; }
    public Boolean allowHotReloadFromIDE = true;
    /**
    * If true, fail if any of the generated header files is out of date.
    */
    public UnrealBuildTool skipRulesCompile(Boolean skipRulesCompile) { this.skipRulesCompile = skipRulesCompile; return this; }
    public Boolean skipRulesCompile = false;

    /**
    * Add the parameters to the specified list.
    */
    public def addParameters(List<String> parameters) {
        Ensure.isSet(this.target, 'target');
        Ensure.isSet(this.clientConfig, 'clientConfig');
        Ensure.isSet(this.targetPlatform, 'targetPlatform');
        Ensure.isSet(this.project, 'project');

        parameters.add(this.target);
        parameters.add(this.clientConfig);
        parameters.add(this.targetPlatform);

        if (this.project) parameters.add('-Project=' + this.project);
        if (this.usePrecompiled) parameters.add('-UsePrecompiled');
        if (!this.allowXGE) parameters.add('-NoXGE');
        if (!this.allowFASTBuild) parameters.add('-NoFASTBuild');
        if (!this.useUBTMakefiles) parameters.add('-NoUBTMakefiles');
        if (this.maxParallelActions > 0) parameters.add('-MaxParallelActions=' + this.maxParallelActions);
        if (this.forceHeaderGeneration) parameters.add('-ForceHeaderGeneration');
        if (this.doNotBuildUHT) parameters.add('-NoBuildUHT');
        if (this.failIfGeneratedCodeChanges) parameters.add('-FailIfGeneratedCodeChanges');
        if (!this.allowHotReloadFromIDE) parameters.add('-NoHotReloadFromIDE');
        if (!this.allowHotReloadFromIDE) parameters.add('-NoHotReloadFromIDE');
        if (this.skipRulesCompile) parameters.add('-SkipRulesCompile');

        super.addParameters(parameters);
    }

    /**
    * Run the command.
    */
    public def run(WorkflowScript context) {
        List<String> parameters = [];
        this.addParameters(parameters);

        String buildScript = context.isUnix() ?
            '"' + this.enginePath + '/Engine/Build/BatchFiles/' + this.targetPlatform + '/RunMono.sh" "' + this.enginePath + '/Engine/Binaries/DotNET/UnrealBuildTool.exe"' :
            '"' + this.enginePath + '\\Engine\\Binaries\\DotNET\\UnrealBuildTool.exe"';

        String command = buildScript + ' ' + parameters.join(' ');

        if (isUnix()) {
            sh(command);
        } else {
            bat(command);
        }
    }
}

UnrealBuildTool build() {
    return new UnrealBuildTool();
}

class Ensure {
    static void isSet(String parameter, String parameterName) {
        if (!parameter) {
            throw new Exception("Parameter ${parameterName} must be set");
        }
    }
}

return this;
