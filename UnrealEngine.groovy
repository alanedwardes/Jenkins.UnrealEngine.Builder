class UnrealBuildToolGlobalOptions {
    /**
    * The path to unreal engine
    */
    public UnrealBuildToolGlobalOptions enginePath(String enginePath) { this.enginePath = enginePath; return this; }
    protected String enginePath;
    /**
    * The amount of detail to write to the log
    */
    public UnrealBuildToolGlobalOptions verbose(Boolean verbose) { this.verbose = verbose; return this; }
    protected Boolean verbose;
    /**
    * The amount of detail to write to the log
    */
    public UnrealBuildToolGlobalOptions veryVerbose(Boolean veryVerbose) { this.veryVerbose = veryVerbose; return this; }
    protected Boolean veryVerbose;
    /**
    * Disables Perforce functionality (default if not run on a build machine)
    */
    public UnrealBuildToolGlobalOptions noPerforce(Boolean noPerforce) { this.noPerforce = noPerforce; return this; }
    protected Boolean noPerforce;
    /**
    * Specifies the path to a log file to write. Note that the default mode (eg. building, generating project files) will create a log file by default if this not specified.
    */
    public UnrealBuildToolGlobalOptions logFileName(String logFileName) { this.logFileName = logFileName; return this; }
    protected String logFileName;
    /**
    * Whether to include timestamps in the log
    */
    public UnrealBuildToolGlobalOptions logTimestamps(Boolean logTimestamps) { this.logTimestamps = logTimestamps; return this; }
    protected Boolean logTimestamps;
    /**
    * Whether to format messages in MsBuild format
    */
    public UnrealBuildToolGlobalOptions logFromMsBuild(Boolean logFromMsBuild) { this.logFromMsBuild = logFromMsBuild; return this; }
    protected Boolean logFromMsBuild;
    /**
    * Whether to write progress markup in a format that can be parsed by other programs
    */
    public UnrealBuildToolGlobalOptions writeProgressMarkup(Boolean writeProgressMarkup) { this.writeProgressMarkup = writeProgressMarkup; return this; }
    protected Boolean writeProgressMarkup;
    /**
    * Whether to ignore the mutex
    */
    public UnrealBuildToolGlobalOptions noMutex(Boolean noMutex) { this.noMutex = noMutex; return this; }
    protected Boolean noMutex;
    /**
    * Whether to wait for the mutex rather than aborting immediately
    */
    public UnrealBuildToolGlobalOptions waitMutex(Boolean waitMutex) { this.waitMutex = waitMutex; return this; }
    protected Boolean waitMutex;
    /**
    * Whether to wait for the mutex rather than aborting immediately
    */
    public UnrealBuildToolGlobalOptions remoteIni(String remoteIni) { this.remoteIni = remoteIni; return this; }
    protected String remoteIni;

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
    protected String deployPath;
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
    protected String clientConfig;
    /**
    * Sets platforms to build for non-dedicated servers
    */
    public UnrealBuildCookRunTool targetPlatform(String targetPlatform) { this.targetPlatform = targetPlatform; return this; }
    protected String targetPlatform;
    /**
    * Package the project for the target platform
    */
    public UnrealBuildCookRunTool project(String project) { this.project = project; return this; }
    protected String project;

    public UnrealBuildCookRunTool scriptsForProject(String scriptsForProject) { this.scriptsForProject = scriptsForProject; return this; }
    protected String scriptsForProject;
    /**
    * Directory to archive the client to
    */
    public UnrealBuildCookRunTool archiveDirectory(String archiveDirectory) { this.archiveDirectory = archiveDirectory; return this; }
    protected String archiveDirectory;
    /**
    * Determines if the build is going to use cooked data
    */
    public UnrealBuildCookRunTool shouldCook(Boolean shouldCook) { this.shouldCook = shouldCook; return this; }
    protected Boolean shouldCook;
    /**
    * Put this build in a stage directory
    */
    public UnrealBuildCookRunTool shouldStage(Boolean shouldStage) { this.shouldStage = shouldStage; return this; }
    protected Boolean shouldStage;
    /**
    * Put this build in an archive directory
    */
    public UnrealBuildCookRunTool shouldArchive(Boolean shouldArchive) { this.shouldArchive = shouldArchive; return this; }
    protected Boolean shouldArchive;
    /**
    * Package for distribution of the project
    */
    public UnrealBuildCookRunTool forDistribution(Boolean forDistribution) { this.forDistribution = forDistribution; return this; }
    protected Boolean forDistribution;
    /**
    * If build step should be executed
    */
    public UnrealBuildCookRunTool shouldBuild(Boolean shouldBuild) { this.shouldBuild = shouldBuild; return this; }
    protected Boolean shouldBuild;
    /**
    * Package the project for the target platform
    */
    public UnrealBuildCookRunTool shouldPackage(Boolean shouldPackage) { this.shouldPackage = shouldPackage; return this; }
    protected Boolean shouldPackage;
    /**
    * Skips content under /Engine/Editor when cooking
    */
    public UnrealBuildCookRunTool skipCookingEditorContent(Boolean skipCookingEditorContent) { this.skipCookingEditorContent = skipCookingEditorContent; return this; }
    protected Boolean skipCookingEditorContent;
    /**
    * Should use packfiles
    */
    public UnrealBuildCookRunTool usePak(Boolean usePak) { this.usePak = usePak; return this; }
    protected Boolean usePak;
    /**
    * The Unreal Engine 4 executable to use
    */
    public UnrealBuildCookRunTool executable(String executable) { this.executable = executable; return this; }
    protected String executable;

    public UnrealBuildCookRunTool noCompileEditor(Boolean noCompileEditor) { this.noCompileEditor = noCompileEditor; return this; }
    protected Boolean noCompileEditor;

    /**
    * Add the parameters to the specified list.
    */
    public def addParameters(List<String> parameters) {
        Ensure.isSet(this.clientConfig, 'clientConfig');
        Ensure.isSet(this.targetPlatform, 'targetPlatform');
        Ensure.isSet(this.project, 'project');

        if (this.clientConfig) parameters.add('-ClientConfig=' + clientConfig);
        if (this.targetPlatform) parameters.add('-TargetPlatform=' + targetPlatform);
        if (this.project) parameters.add('-Project="' + project + '"');
        if (this.scriptsForProject) parameters.add('-ScriptsForProject="' + scriptsForProject + '"');
        if (this.archiveDirectory) parameters.add('-ArchiveDirectory="' + archiveDirectory + '"');
        if (this.shouldCook) parameters.add('-Cook');
        if (this.shouldStage) parameters.add('-Stage');
        if (this.shouldArchive) parameters.add('-Archive');
        if (this.forDistribution) parameters.add('-Distribution');
        if (this.shouldBuild) parameters.add('-Build');
        if (this.shouldPackage) parameters.add('-Package');
        if (this.skipCookingEditorContent) parameters.add('-SkipCookingEditorContent');
        if (this.usePak) parameters.add('-Pak');
        if (this.executable) parameters.add('-UE4exe="' + executable + '"');
        if (this.noCompileEditor) parameters.add('-NoCompileEditor');

        super.addParameters(parameters);
    }

    /**
    * Run the command.
    */
    public def UnrealBuildCookRunResult run(WorkflowScript context) {
        List<String> parameters = [];
        this.addParameters(parameters);

        String buildScript = context.isUnix() ?
            '"' + this.enginePath + '/Engine/Build/BatchFiles/RunUAT.sh"' :
            '"' + this.enginePath + '\\Engine\\Build\\BatchFiles\\RunUAT.bat"';

        String command = buildScript + ' BuildCookRun ' + parameters.join(' ');

        if (context.isUnix()) {
            context.sh(command);
        } else {
            context.bat(command);
        }
        
        UnrealBuildCookRunResult result = new UnrealBuildCookRunResult();
        result.deployPath = this.archiveDirectory;
        return result;
    }
}

UnrealBuildCookRunTool buildCookRun() {
    return new UnrealBuildCookRunTool();
}

class SymbolExtractorTool {
    public SymbolExtractorTool symstore(String symstore) { this.symstore = symstore; return this; }
    protected String symstore;

    public SymbolExtractorTool source(String source) { this.source = source; return this; }
    protected String source;

    public SymbolExtractorTool destination(String destination) { this.destination = destination; return this; }
    protected String destination;

    public SymbolExtractorTool product(String product) { this.product = product; return this; }
    protected String product;

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
    protected String target;
    /**
    * List of client configurations:
       * Debug
       * Shipping
       * Test
       * Development
       * DebugGame
    */
    public UnrealBuildTool clientConfig(String clientConfig) { this.clientConfig = clientConfig; return this; }
    protected String clientConfig;
    /**
    * Sets platforms to build for non-dedicated servers
    */
    public UnrealBuildTool targetPlatform(String targetPlatform) { this.targetPlatform = targetPlatform; return this; }
    protected String targetPlatform;
    /**
    * Package the project for the target platform
    */
    public UnrealBuildTool project(String project) { this.project = project; return this; }
    protected String project;
    /**
    * Use existing static libraries for all engine modules in this target.
    */
    public UnrealBuildTool usePrecompiled(Boolean usePrecompiled) { this.usePrecompiled = usePrecompiled; return this; }
    protected Boolean usePrecompiled = false;
    /**
    * Whether XGE may be used.
    */
    public UnrealBuildTool allowXGE(Boolean allowXGE) { this.allowXGE = allowXGE; return this; }
    protected Boolean allowXGE = true;
    /**
    * Whether FASTBuild may be used.
    */
    public UnrealBuildTool allowFASTBuild(Boolean allowFASTBuild) { this.allowFASTBuild = allowFASTBuild; return this; }
    protected Boolean allowFASTBuild = true;
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
    public UnrealBuildTool useUBTMakefiles(Boolean useUBTMakefiles) { this.useUBTMakefiles = useUBTMakefiles; return this; }
    protected Boolean useUBTMakefiles = true;
    /**
    * Number of actions that can be executed in parallel. If 0 then code will pick a default based on the number of cores available. Only applies to the ParallelExecutor
    */
    public UnrealBuildTool maxParallelActions(Integer maxParallelActions) { this.maxParallelActions = maxParallelActions; return this; }
    protected Integer maxParallelActions = 0;
    /**
    * If true, force header regeneration. Intended for the build machine.
    */
    public UnrealBuildTool forceHeaderGeneration(Boolean forceHeaderGeneration) { this.forceHeaderGeneration = forceHeaderGeneration; return this; }
    protected Boolean forceHeaderGeneration = false;
    /**
    * If true, do not build UHT, assume it is already built.
    */
    public UnrealBuildTool doNotBuildUHT(Boolean doNotBuildUHT) { this.doNotBuildUHT = doNotBuildUHT; return this; }
    protected Boolean doNotBuildUHT = false;
    /**
    * If true, fail if any of the generated header files is out of date.
    */
    public UnrealBuildTool failIfGeneratedCodeChanges(Boolean failIfGeneratedCodeChanges) { this.failIfGeneratedCodeChanges = failIfGeneratedCodeChanges; return this; }
    protected Boolean failIfGeneratedCodeChanges = false;
    /**
    * True if hot-reload from IDE is allowed.
    */
    public UnrealBuildTool allowHotReloadFromIDE(Boolean allowHotReloadFromIDE) { this.allowHotReloadFromIDE = allowHotReloadFromIDE; return this; }
    protected Boolean allowHotReloadFromIDE = true;
    /**
    * If true, fail if any of the generated header files is out of date.
    */
    public UnrealBuildTool skipRulesCompile(Boolean skipRulesCompile) { this.skipRulesCompile = skipRulesCompile; return this; }
    protected Boolean skipRulesCompile = false;

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

        if (this.project) parameters.add('-Project="' + this.project + '"');
        if (this.usePrecompiled) parameters.add('-UsePrecompiled');
        if (!this.allowXGE) parameters.add('-NoXGE');
        if (!this.allowFASTBuild) parameters.add('-NoFASTBuild');
        if (!this.useUBTMakefiles) parameters.add('-NoUBTMakefiles');
        if (this.maxParallelActions > 0) parameters.add('-MaxParallelActions=' + this.maxParallelActions);
        if (this.forceHeaderGeneration) parameters.add('-ForceHeaderGeneration');
        if (this.doNotBuildUHT) parameters.add('-NoBuildUHT');
        if (this.failIfGeneratedCodeChanges) parameters.add('-FailIfGeneratedCodeChanges');
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
            '"' + this.enginePath + '\\Engine\\Binaries\\DotNET\\UnrealBuildTool\\UnrealBuildTool.exe"';

        String command = buildScript + ' ' + parameters.join(' ');

        if (context.isUnix()) {
            context.sh(command);
        } else {
            context.bat(command);
        }
    }
}

UnrealBuildTool build() {
    return new UnrealBuildTool();
}

class UnrealResavePackagesTool {
    /**
    * The path to unreal engine
    */
    public UnrealBuildToolGlobalOptions enginePath(String enginePath) { this.enginePath = enginePath; return this; }
    protected String enginePath;

    /**
    * Package the project for the target platform
    */
    public UnrealBuildTool project(String project) { this.project = project; return this; }
    protected String project;

    /**
    * Sets platforms to build for non-dedicated servers
    */
    public UnrealBuildCookRunTool targetPlatform(String targetPlatform) { this.targetPlatform = targetPlatform; return this; }
    protected String targetPlatform;

    public UnrealBuildTool skipMaps(Boolean skipMaps) { this.skipMaps = skipMaps; return this; }
    protected Boolean skipMaps;

    public UnrealBuildTool mapsOnly(Boolean mapsOnly) { this.mapsOnly = mapsOnly; return this; }
    protected Boolean mapsOnly;
    
    public UnrealBuildTool projectOnly(Boolean projectOnly) { this.projectOnly = projectOnly; return this; }
    protected Boolean projectOnly;

    public UnrealBuildTool skipDeveloperFolders(Boolean skipDeveloperFolders) { this.skipDeveloperFolders = skipDeveloperFolders; return this; }
    protected Boolean skipDeveloperFolders;

    public UnrealBuildTool onlyDeveloperFolders(Boolean onlyDeveloperFolders) { this.onlyDeveloperFolders = onlyDeveloperFolders; return this; }
    protected Boolean onlyDeveloperFolders;

    /**
    * This option will filter the package list and only save packages that are redirectors, or that reference redirectors
    */
    public UnrealBuildTool fixupRedirects(Boolean fixupRedirects) { this.fixupRedirects = fixupRedirects; return this; }
    protected Boolean fixupRedirects;

    /**
    * Determine if we are building lighting for the map packages on the pass.
    */
    public UnrealBuildTool buildLighting(Boolean buildLighting) { this.buildLighting = buildLighting; return this; }
    protected Boolean buildLighting;

    /**
    * Determine if we are building reflection captures for the map packages on the pass.
    */
    public UnrealBuildTool buildReflectionCaptures(Boolean buildReflectionCaptures) { this.buildReflectionCaptures = buildReflectionCaptures; return this; }
    protected Boolean buildReflectionCaptures;

    /**
    * Rebuilds texture streaming data for all packages, rather than just maps.
    */
    public UnrealBuildTool buildTextureStreamingForAll(Boolean buildTextureStreamingForAll) { this.buildTextureStreamingForAll = buildTextureStreamingForAll; return this; }
    protected Boolean buildTextureStreamingForAll;

    /**
    * Determine if we are building texture streaming data for the map packages on the pass.
    */
    public UnrealBuildTool buildTextureStreaming(Boolean buildTextureStreaming) { this.buildTextureStreaming = buildTextureStreaming; return this; }
    protected Boolean buildTextureStreaming;

    /**
    * Only process packages containing materials.
    */
    public UnrealBuildTool onlyMaterials(Boolean onlyMaterials) { this.onlyMaterials = onlyMaterials; return this; }
    protected Boolean onlyMaterials;

    /**
    * Determine if we are building navigation data for the map packages on the pass.
    */
    public UnrealBuildTool buildNavigationData(Boolean buildNavigationData) { this.buildNavigationData = buildNavigationData; return this; }
    protected Boolean buildNavigationData;

    /**
    * Check for filtering packages by collection.
    */
    public UnrealBuildTool filterByCollection(String filterByCollection) { this.filterByCollection = filterByCollection; return this; }
    protected String filterByCollection;

    /**
    * Determine if we are building navigation data for the map packages on the pass.
    */
    public UnrealBuildTool buildHLOD(Boolean buildHLOD) { this.buildHLOD = buildHLOD; return this; }
    protected Boolean buildHLOD;

    public UnrealBuildTool allowCommandletRendering(Boolean allowCommandletRendering) { this.allowCommandletRendering = allowCommandletRendering; return this; }
    protected Boolean allowCommandletRendering;

    /**
    * Default build on production.
    */
    public UnrealBuildTool quality(String quality) { this.quality = quality; return this; }
    protected String quality;

    /**
    * Allow for an option to restart at a given package name (in case it dies during a run, etc)
    */
    public UnrealBuildTool firstPackage(String firstPackage) { this.firstPackage = firstPackage; return this; }
    protected String firstPackage;

    public UnrealBuildTool packageSubString(String packageSubString) { this.packageSubString = packageSubString; return this; }
    protected String packageSubString;

    public UnrealBuildTool addMap(String map) { this.maps.add(map); return this; }
    public List<String> maps = [];

    public def addParameters(List<String> parameters) {
        Ensure.isSet(this.enginePath, 'enginePath');
        Ensure.isSet(this.project, 'project');
        Ensure.isSet(this.targetPlatform, 'targetPlatform');

        parameters.add('"' + this.project + '"');
        parameters.add('-run=ResavePackages');
        if (this.skipMaps) parameters.add('-SkipMaps');
        if (this.mapsOnly) parameters.add('-MapsOnly');
        if (this.projectOnly) parameters.add('-ProjectOnly');
        if (this.skipDeveloperFolders) parameters.add('-SkipDeveloperFolders');
        if (this.onlyDeveloperFolders) parameters.add('-OnlyDeveloperFolders');
        if (this.fixupRedirects) parameters.add('-FixupRedirects');
        if (this.buildLighting) parameters.add('-BuildLighting');
        if (this.buildReflectionCaptures) parameters.add('-BuildReflectionCaptures');
        if (this.buildTextureStreamingForAll) parameters.add('-BuildTextureStreamingForAll');
        if (this.buildTextureStreaming) parameters.add('-BuildTextureStreaming');
        if (this.onlyMaterials) parameters.add('-OnlyMaterials');
        if (this.buildNavigationData) parameters.add('-BuildNavigationData');
        if (this.filterByCollection) parameters.add('-FilterByCollection=' + this.filterByCollection);
        if (this.buildHLOD) parameters.add('-BuildHLOD');
        if (this.allowCommandletRendering) parameters.add('-AllowCommandletRendering');
        if (this.quality) parameters.add('-Quality=' + this.quality);
        if (this.firstPackage) parameters.add('-FirstPackage=' + this.firstPackage);
        if (this.packageSubString) parameters.add('-PackageSubString=' + this.packageSubString);
        if (this.maps.size() > 0) parameters.add('-Map="' + this.maps.join('"+"') + '"');
    }

    /**
    * Run the command.
    */
    public def run(WorkflowScript context) {
        List<String> parameters = [];
        this.addParameters(parameters);

        String buildScript = context.isUnix() ?
            '"' + this.enginePath + '/Engine/Binaries/' + this.targetPlatform + '/UE4Editor-Cmd"' :
            '"' + this.enginePath + '\\Engine\\Binaries\\' + this.targetPlatform + '\\UE4Editor-Cmd.exe"';

        String command = buildScript + ' ' + parameters.join(' ');

        if (context.isUnix()) {
            context.sh(command);
        } else {
            context.bat(command);
        }
    }
}

UnrealResavePackagesTool resavePackages() {
    return new UnrealResavePackagesTool();
}

class Ensure {
    static void isSet(String parameter, String parameterName) {
        if (!parameter) {
            throw new Exception("Parameter ${parameterName} must be set");
        }
    }
}

return this;
