class UnrealBuildToolGlobalOptions {
    /**
    * The path to unreal engine
    */
    public def enginePath(String enginePath) { this.enginePath = enginePath; return this; }
    private String enginePath;
    /**
    * The amount of detail to write to the log
    */
    public def verbose(String verbose) { this.verbose = verbose; return this; }
    private Boolean verbose;
    /**
    * The amount of detail to write to the log
    */
    public def veryVerbose(String verbose) { this.veryVerbose = veryVerbose; return this; }
    private Boolean veryVerbose;
    /**
    * Disables Perforce functionality (default if not run on a build machine)
    */
    public def noPerforce(String noPerforce) { this.noPerforce = noPerforce; return this; }
    private Boolean noPerforce;
    /**
    * Specifies the path to a log file to write. Note that the default mode (eg. building, generating project files) will create a log file by default if this not specified.
    */
    public def logFileName(String logFileName) { this.logFileName = logFileName; return this; }
    private String logFileName;
    /**
    * Whether to include timestamps in the log
    */
    public def logTimestamps(String logTimestamps) { this.logTimestamps = logTimestamps; return this; }
    private Boolean logTimestamps;
    /**
    * Whether to format messages in MsBuild format
    */
    public def logFromMsBuild(String logFromMsBuild) { this.logFromMsBuild = logFromMsBuild; return this; }
    private Boolean logFromMsBuild;
    /**
    * Whether to write progress markup in a format that can be parsed by other programs
    */
    public def writeProgressMarkup(String writeProgressMarkup) { this.writeProgressMarkup = writeProgressMarkup; return this; }
    private Boolean writeProgressMarkup;
    /**
    * Whether to ignore the mutex
    */
    public def noMutex(String noMutex) { this.noMutex = noMutex; return this; }
    private Boolean noMutex;
    /**
    * Whether to wait for the mutex rather than aborting immediately
    */
    public def waitMutex(String waitMutex) { this.waitMutex = waitMutex; return this; }
    private Boolean waitMutex;
    /**
    * Whether to wait for the mutex rather than aborting immediately
    */
    public def remoteIni(String remoteIni) { this.remoteIni = remoteIni; return this; }
    private String remoteIni;

    /**
    * Add the parameters to the specified list.
    */
    public def addParameters(List<String> parameters) {
        if (verbose) parameters.add('-Verbose');
        if (veryVerbose) parameters.add('-VeryVerbose');
        if (noPerforce) parameters.add('-NoP4');
        if (logFileName) parameters.add('-Log=' + parameters.LogFileName);
        if (logTimestamps) parameters.add('-Timestamps');
        if (logFromMsBuild) parameters.add('-FromMsBuild');
        if (writeProgressMarkup) parameters.add('-Progress');
        if (noMutex) parameters.add('-NoMutex');
        if (waitMutex) parameters.add('-WaitMutex');
        if (remoteIni) parameters.add('-RemoteIni');
    }
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
    public def clientConfig(String clientConfig) { this.clientConfig = clientConfig; return this; }
    private String clientConfig;
    /**
    * Sets platforms to build for non-dedicated servers
    */
    public def targetPlatform(String targetPlatform) { this.targetPlatform = targetPlatform; return this; }
    private String targetPlatform;
    /**
    * Package the project for the target platform
    */
    public def project(String project) { this.project = project; return this; }
    private String project;

    public def scriptsForProject(String project) { this.scriptsForProject = scriptsForProject; return this; }
    private String scriptsForProject;
    /**
    * Directory to archive the client to
    */
    public def archiveDirectory(String project) { this.archiveDirectory = archiveDirectory; return this; }
    private String archiveDirectory;
    /**
    * Determines if the build is going to use cooked data
    */
    public def shouldCook(String project) { this.shouldCook = shouldCook; return this; }
    private Boolean shouldCook;
    /**
    * Put this build in a stage directory
    */
    public def shouldStage(String project) { this.shouldStage = shouldStage; return this; }
    private Boolean shouldStage;
    /**
    * Put this build in an archive directory
    */
    public def shouldArchive(String shouldArchive) { this.shouldArchive = shouldArchive; return this; }
    private Boolean shouldArchive;
    /**
    * Package for distribution of the project
    */
    public def forDistribution(String forDistribution) { this.forDistribution = forDistribution; return this; }
    private Boolean forDistribution;
    /**
    * If build step should be executed
    */
    public def shouldBuild(String shouldBuild) { this.shouldBuild = shouldBuild; return this; }
    private Boolean shouldBuild;
    /**
    * Package the project for the target platform
    */
    public def shouldPackage(String shouldPackage) { this.shouldPackage = shouldPackage; return this; }
    private Boolean shouldPackage;
    /**
    * Skips content under /Engine/Editor when cooking
    */
    public def skipCookingEditorContent(String skipCookingEditorContent) { this.skipCookingEditorContent = skipCookingEditorContent; return this; }
    private Boolean skipCookingEditorContent;
    /**
    * Should use packfiles
    */
    public def usePak(String skipCookingEditorContent) { this.usePak = usePak; return this; }
    private Boolean usePak;
    /**
    * The Unreal Engine 4 executable to use
    */
    public def executable(String skipCookingEditorContent) { this.executable = executable; return this; }
    private String executable;

    public def noCompileEditor(String noCompileEditor) { this.noCompileEditor = noCompileEditor; return this; }
    private String noCompileEditor;

    /**
    * Add the parameters to the specified list.
    */
    public def addParameters(List<String> parameters) {
        super.addParameters(parameters);
        if (clientConfig) parameters.add('-ClientConfig=' + clientConfig);
        if (targetPlatform) parameters.add('-TargetPlatform=' + targetPlatform);
        if (project) parameters.add('-Project=' + project);
        if (scriptsForProject) parameters.add('-ScriptsForProject=' + scriptsForProject);
        if (archiveDirectory) parameters.add('-ArchiveDirectory=' + archiveDirectory);
        if (shouldCook) parameters.add('-Cook');
        if (shouldStage) parameters.add('-Stage');
        if (shouldArchive) parameters.add('-Archive');
        if (forDistribution) parameters.add('-Distribution');
        if (shouldBuild) parameters.add('-Build');
        if (shouldPackage) parameters.add('-Package');
        if (skipCookingEditorContent) parameters.add('-SkipCookingEditorContent');
        if (usePak) parameters.add('-Pak');
        if (executable) parameters.add('-UE4exe=' + executable);
        if (noCompileEditor) parameters.add('-NoCompileEditor');
    }
}

UnrealBuildCookRunParameters createBuildCookRunParameters() {
    return new UnrealBuildCookRunParameters();
}

def buildCookRun(UnrealBuildCookRunParameters parameters) {
    String buildScript = isUnix() ? '/Engine/Build/BatchFiles/RunUAT.sh' : '\\Engine\\Build\\BatchFiles\\RunUAT.bat';

    List<String> UATParameters = [];
    parameters.addParameters(UATParameters);

    String command = parameters.enginePath + buildScript + ' BuildCookRun ' + UATParameters.join(' ');

    echo "Running UAT command: " + command;

    if (isUnix()) {
        sh command
    } else {
        bat command
    }
}

return this;
