class UnrealBuildToolGlobalOptions {
    /**
    * The path to unreal engine
    */
    public def enginePath(String enginePath) { _enginePath = enginePath; return this; }
    public def getEnginePath() { return _enginePath; }
    private String _enginePath;
    /**
    * The amount of detail to write to the log
    */
    public def verbose(String verbose) { _verbose = verbose; return this; }
    private Boolean _verbose;
    /**
    * The amount of detail to write to the log
    */
    public def veryVerbose(String verbose) { _veryVerbose = veryVerbose; return this; }
    private Boolean _veryVerbose;
    /**
    * Disables Perforce functionality (default if not run on a build machine)
    */
    public def noPerforce(String noPerforce) { _noPerforce = noPerforce; return this; }
    private Boolean _noPerforce;
    /**
    * Specifies the path to a log file to write. Note that the default mode (eg. building, generating project files) will create a log file by default if this not specified.
    */
    public def logFileName(String logFileName) { _logFileName = logFileName; return this; }
    private String _logFileName;
    /**
    * Whether to include timestamps in the log
    */
    public def logTimestamps(String logTimestamps) { _logTimestamps = logTimestamps; return this; }
    private Boolean _logTimestamps;
    /**
    * Whether to format messages in MsBuild format
    */
    public def logFromMsBuild(String logFromMsBuild) { _logFromMsBuild = logFromMsBuild; return this; }
    private Boolean _logFromMsBuild;
    /**
    * Whether to write progress markup in a format that can be parsed by other programs
    */
    public def writeProgressMarkup(String writeProgressMarkup) { _writeProgressMarkup = writeProgressMarkup; return this; }
    private Boolean _writeProgressMarkup;
    /**
    * Whether to ignore the mutex
    */
    public def noMutex(String noMutex) { _noMutex = noMutex; return this; }
    private Boolean _noMutex;
    /**
    * Whether to wait for the mutex rather than aborting immediately
    */
    public def waitMutex(String waitMutex) { _waitMutex = waitMutex; return this; }
    private Boolean _waitMutex;
    /**
    * Whether to wait for the mutex rather than aborting immediately
    */
    public def remoteIni(String remoteIni) { _remoteIni = remoteIni; return this; }
    private String _remoteIni;

    /**
    * Add the parameters to the specified list.
    */
    public def addParameters(List<String> parameters) {
        if (_verbose) parameters.add('-Verbose');
        if (_veryVerbose) parameters.add('-VeryVerbose');
        if (_noPerforce) parameters.add('-NoP4');
        if (_logFileName) parameters.add('-Log=' + _logFileName);
        if (_logTimestamps) parameters.add('-Timestamps');
        if (_logFromMsBuild) parameters.add('-FromMsBuild');
        if (_writeProgressMarkup) parameters.add('-Progress');
        if (_noMutex) parameters.add('-NoMutex');
        if (_waitMutex) parameters.add('-WaitMutex');
        if (_remoteIni) parameters.add('-RemoteIni');
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
    public def clientConfig(String clientConfig) { _clientConfig = clientConfig; return this; }
    private String _clientConfig;
    /**
    * Sets platforms to build for non-dedicated servers
    */
    public def targetPlatform(String targetPlatform) { _targetPlatform = targetPlatform; return this; }
    private String _targetPlatform;
    /**
    * Package the project for the target platform
    */
    public def project(String project) { _project = project; return this; }
    private String _project;

    public def scriptsForProject(String project) { _scriptsForProject = scriptsForProject; return this; }
    private String _scriptsForProject;
    /**
    * Directory to archive the client to
    */
    public def archiveDirectory(String project) { _archiveDirectory = archiveDirectory; return this; }
    private String _archiveDirectory;
    /**
    * Determines if the build is going to use cooked data
    */
    public def shouldCook(String project) { _shouldCook = shouldCook; return this; }
    private Boolean _shouldCook;
    /**
    * Put this build in a stage directory
    */
    public def shouldStage(String project) { _shouldStage = shouldStage; return this; }
    private Boolean _shouldStage;
    /**
    * Put this build in an archive directory
    */
    public def shouldArchive(String shouldArchive) { _shouldArchive = shouldArchive; return this; }
    private Boolean _shouldArchive;
    /**
    * Package for distribution of the project
    */
    public def forDistribution(String forDistribution) { _forDistribution = forDistribution; return this; }
    private Boolean _forDistribution;
    /**
    * If build step should be executed
    */
    public def shouldBuild(String shouldBuild) { _shouldBuild = shouldBuild; return this; }
    private Boolean _shouldBuild;
    /**
    * Package the project for the target platform
    */
    public def shouldPackage(String shouldPackage) { _shouldPackage = shouldPackage; return this; }
    private Boolean _shouldPackage;
    /**
    * Skips content under /Engine/Editor when cooking
    */
    public def skipCookingEditorContent(String skipCookingEditorContent) { _skipCookingEditorContent = skipCookingEditorContent; return this; }
    private Boolean _skipCookingEditorContent;
    /**
    * Should use packfiles
    */
    public def usePak(String skipCookingEditorContent) { _usePak = usePak; return this; }
    private Boolean _usePak;
    /**
    * The Unreal Engine 4 executable to use
    */
    public def executable(String skipCookingEditorContent) { _executable = executable; return this; }
    private String _executable;

    public def noCompileEditor(String noCompileEditor) { _noCompileEditor = noCompileEditor; return this; }
    private String _noCompileEditor;

    /**
    * Add the parameters to the specified list.
    */
    public def addParameters(List<String> parameters) {
        super.addParameters(parameters);
        if (_clientConfig) parameters.add('-ClientConfig=' + _clientConfig);
        if (_targetPlatform) parameters.add('-TargetPlatform=' + _targetPlatform);
        if (_project) parameters.add('-Project=' + project);
        if (_scriptsForProject) parameters.add('-ScriptsForProject=' + _scriptsForProject);
        if (_archiveDirectory) parameters.add('-ArchiveDirectory=' + _archiveDirectory);
        if (_shouldCook) parameters.add('-Cook');
        if (_shouldStage) parameters.add('-Stage');
        if (_shouldArchive) parameters.add('-Archive');
        if (_forDistribution) parameters.add('-Distribution');
        if (_shouldBuild) parameters.add('-Build');
        if (_shouldPackage) parameters.add('-Package');
        if (_skipCookingEditorContent) parameters.add('-SkipCookingEditorContent');
        if (_usePak) parameters.add('-Pak');
        if (_executable) parameters.add('-UE4exe=' + executable);
        if (_noCompileEditor) parameters.add('-NoCompileEditor');
    }
}

UnrealBuildCookRunParameters createBuildCookRunParameters() {
    return new UnrealBuildCookRunParameters();
}

def buildCookRun(UnrealBuildCookRunParameters parameters) {
    String buildScript = isUnix() ? '/Engine/Build/BatchFiles/RunUAT.sh' : '\\Engine\\Build\\BatchFiles\\RunUAT.bat';

    List<String> UATParameters = [];
    parameters.addParameters(UATParameters);

    String command = parameters.getEnginePath() + buildScript + ' BuildCookRun ' + UATParameters.join(' ');

    echo "Running UAT command: " + command;

    if (isUnix()) {
        sh(command);
    } else {
        bat(command);
    }
}

return this;
