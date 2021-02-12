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

class UnrealBuildCookRunParameters extends UnrealBuildToolGlobalOptions {
    /**
    * List of client configurations:
       * Debug
       * Shipping
       * Test
       * Development
       * DebugGame
    */
    public UnrealBuildCookRunParameters clientConfig(String clientConfig) { this.clientConfig = clientConfig; return this; }
    public String clientConfig;
    /**
    * Sets platforms to build for non-dedicated servers
    */
    public UnrealBuildCookRunParameters targetPlatform(String targetPlatform) { this.targetPlatform = targetPlatform; return this; }
    public String targetPlatform;
    /**
    * Package the project for the target platform
    */
    public UnrealBuildCookRunParameters project(String project) { this.project = project; return this; }
    public String project;

    public UnrealBuildCookRunParameters scriptsForProject(String scriptsForProject) { this.scriptsForProject = scriptsForProject; return this; }
    public String scriptsForProject;
    /**
    * Directory to archive the client to
    */
    public UnrealBuildCookRunParameters archiveDirectory(String archiveDirectory) { this.archiveDirectory = archiveDirectory; return this; }
    public String archiveDirectory;
    /**
    * Determines if the build is going to use cooked data
    */
    public UnrealBuildCookRunParameters shouldCook(Boolean shouldCook) { this.shouldCook = shouldCook; return this; }
    public Boolean shouldCook;
    /**
    * Put this build in a stage directory
    */
    public UnrealBuildCookRunParameters shouldStage(Boolean shouldStage) { this.shouldStage = shouldStage; return this; }
    public Boolean shouldStage;
    /**
    * Put this build in an archive directory
    */
    public UnrealBuildCookRunParameters shouldArchive(Boolean shouldArchive) { this.shouldArchive = shouldArchive; return this; }
    public Boolean shouldArchive;
    /**
    * Package for distribution of the project
    */
    public UnrealBuildCookRunParameters forDistribution(Boolean forDistribution) { this.forDistribution = forDistribution; return this; }
    public Boolean forDistribution;
    /**
    * If build step should be executed
    */
    public UnrealBuildCookRunParameters shouldBuild(Boolean shouldBuild) { this.shouldBuild = shouldBuild; return this; }
    public Boolean shouldBuild;
    /**
    * Package the project for the target platform
    */
    public UnrealBuildCookRunParameters shouldPackage(Boolean shouldPackage) { this.shouldPackage = shouldPackage; return this; }
    public Boolean shouldPackage;
    /**
    * Skips content under /Engine/Editor when cooking
    */
    public UnrealBuildCookRunParameters skipCookingEditorContent(Boolean skipCookingEditorContent) { this.skipCookingEditorContent = skipCookingEditorContent; return this; }
    public Boolean skipCookingEditorContent;
    /**
    * Should use packfiles
    */
    public UnrealBuildCookRunParameters usePak(Boolean usePak) { this.usePak = usePak; return this; }
    public Boolean usePak;
    /**
    * The Unreal Engine 4 executable to use
    */
    public UnrealBuildCookRunParameters executable(String executable) { this.executable = executable; return this; }
    public String executable;

    public UnrealBuildCookRunParameters noCompileEditor(String noCompileEditor) { this.noCompileEditor = noCompileEditor; return this; }
    public String noCompileEditor;

    /**
    * Add the parameters to the specified list.
    */
    public def addParameters(List<String> parameters) {
        super.addParameters(parameters);
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

UnrealBuildCookRunParameters buildCookRun() {
    return new UnrealBuildCookRunParameters();
}

return this;
