class UnrealBuildToolGlobalOptions {
    /**
    * The path to unreal engine
    */
    public String enginePath;
    /**
    * The amount of detail to write to the log
    */
    public Boolean verbose;
    /**
    * The amount of detail to write to the log
    */
    public Boolean veryVerbose;
    /**
    * Specifies the path to a log file to write. Note that the default mode (eg. building, generating project files) will create a log file by default if this not specified.
    */
    public String logFileName;
    /**
    * Whether to include timestamps in the log
    */
    public Boolean logTimestamps;
    /**
    * Whether to format messages in MsBuild format
    */
    public Boolean logFromMsBuild;
    /**
    * Whether to write progress markup in a format that can be parsed by other programs
    */
    public Boolean writeProgressMarkup;
    /**
    * Whether to ignore the mutex
    */
    public Boolean noMutex;
    /**
    * Whether to wait for the mutex rather than aborting immediately
    */
    public Boolean waitMutex;
    /**
    * Whether to wait for the mutex rather than aborting immediately
    */
    public String remoteIni;

    /**
    * Add the parameters to the specified list.
    */
    public def addParameters(List<String> parameters) {
        if (verbose) parameters.add('-verbose');
        if (veryVerbose) parameters.add('-veryverbose');
        if (noPerforce) parameters.add('-nop4');
        if (logFileName) parameters.add('-logFileName=' + parameters.LogFileName);
        if (logTimestamps) parameters.add('-logtimestamps');
        if (logFromMsBuild) parameters.add('-logfrommsbuild');
        if (writeProgressMarkup) parameters.add('-writeprogressmarkup');
        if (noMutex) parameters.add('-nomutex');
        if (waitMutex) parameters.add('-waitmutex');
        if (writeProgressMarkup) parameters.add('-writeprogressmarkup');
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
    public String clientConfig;
    /**
    * Sets platforms to build for non-dedicated servers
    */
    public String targetPlatform;
    /**
    * Package the project for the target platform
    */
    public String project;
    public String scriptsForProject;
    /**
    * Directory to archive the client to
    */
    public String archiveDirectory;
    /**
    * Disables Perforce functionality (default if not run on a build machine)
    */
    public Boolean noPerforce;
    /**
    * Determines if the build is going to use cooked data
    */
    public Boolean shouldCook;
    /**
    * Put this build in a stage directory
    */
    public Boolean shouldStage;
    /**
    * Put this build in an archive directory
    */
    public Boolean shouldArchive;
    /**
    * Package for distribution of the project
    */
    public Boolean forDistribution;
    /**
    * If build step should be executed
    */
    public Boolean shouldBuild;
    /**
    * Package the project for the target platform
    */
    public Boolean shouldPackage;
    /**
    * Skips content under /Engine/Editor when cooking
    */
    public Boolean skipCookingEditorContent;
    /**
    * Should use packfiles
    */
    public Boolean usePak;

    /**
    * Add the parameters to the specified list.
    */
    public def addParameters(List<String> parameters) {
        super.addParameters(parameters);
        if (clientConfig) parameters.add('-clientconfig=' + clientConfig);
        if (targetPlatform) parameters.add('-targetplatform=' + targetPlatform);
        if (project) parameters.add('-project=' + project);
        if (scriptsForProject) parameters.add('-ScriptsForProject=' + scriptsForProject);
        if (archiveDirectory) parameters.add('-archivedirectory=' + archiveDirectory);
        if (noPerforce) parameters.add('-nop4');
        if (shouldCook) parameters.add('-cook');
        if (shouldStage) parameters.add('-stage');
        if (shouldArchive) parameters.add('-archive');
        if (forDistribution) parameters.add('-distribution');
        if (shouldBuild) parameters.add('-build');
        if (shouldPackage) parameters.add('-package');
        if (skipCookingEditorContent) parameters.add('-SkipCookingEditorContent');
        if (usePak) parameters.add('-pak');
    }
}

UnrealBuildCookRunParameters createBuildCookRunParameters() {
    return new UnrealBuildCookRunParameters();
}

def buildCookRun(UnrealBuildCookRunParameters parameters) {
    String buildScript = isUnix() ? '/Engine/Build/BatchFiles/RunUAT.sh' : '\\Engine\\Build\\BatchFiles\\RunUAT.bat';
    
    List<String> UATParameters = [];
    parameters.addParameters(UATParameters);

    String command = parameters.enginePath + buildScript + ' ' + UATParameters.join(' ');

    echo "Running UAT command: " + command;

    if (isUnix()) {
        sh command
    } else {
        bat command
    }
}

return this;
