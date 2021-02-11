enum UnrealClientConfig {
    Unknown,
    Debug,
    Shipping,
    Test,
    Development,
    DebugGame
}

class UnrealBuildToolGlobalOptions {
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

    public def addParameters(List<String> parameters) {
        if (parameters.verbose) {
            parameters.add('-verbose');
        }

        if (parameters.veryVerbose) {
            parameters.add('-veryverbose');
        }

        if (parameters.noPerforce) {
            parameters.add('-nop4');
        }

        if (parameters.logFileName) {
            parameters.add('-logFileName=' + parameters.LogFileName);
        }

        if (parameters.logTimestamps) {
            parameters.add('-logtimestamps');
        }

        if (parameters.logFromMsBuild) {
            parameters.add('-logfrommsbuild');
        }

        if (parameters.writeProgressMarkup) {
            parameters.add('-writeprogressmarkup');
        }

        if (parameters.noMutex) {
            parameters.add('-nomutex');
        }

        if (parameters.waitMutex) {
            parameters.add('-waitmutex');
        }

        if (parameters.writeProgressMarkup) {
            parameters.add('-writeprogressmarkup');
        }
    }
}

class UnrealBuildCookRunParameters extends UnrealBuildToolGlobalOptions {
    /**
    * List of client configurations
    */
    public UnrealClientConfig clientConfig;
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
    public Boolean cook;
    /**
    * Put this build in a stage directory
    */
    public Boolean stage;
    /**
    * Put this build in an archive directory
    */
    public Boolean archive;
    /**
    * Package for distribution of the project
    */
    public Boolean distribution;
    /**
    * If build step should be executed
    */
    public Boolean build;
    /**
    * Package the project for the target platform
    */
    public Boolean testpackage;
    /**
    * Skips content under /Engine/Editor when cooking
    */
    public Boolean skipCookingEditorContent;
}

UnrealBuildCookRunParameters createBuildCookRunParameters() {
    return new UnrealBuildCookRunParameters();
}

def buildCookRun(UnrealBuildCookRunParameters parameters) {
    List<String> UATParameters = [];

    parameters.addParameters(UATParameters);

    UATParameters.each { Parameter ->
        echo "Hello ${Parameter}"
    }
}

return this;
