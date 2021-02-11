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
    public Boolean Verbose;
    /**
    * The amount of detail to write to the log
    */
    public Boolean VeryVerbose;
    /**
    * Specifies the path to a log file to write. Note that the default mode (eg. building, generating project files) will create a log file by default if this not specified.
    */
    public String LogFileName;
    /**
    * Whether to include timestamps in the log
    */
    public Boolean LogTimestamps;
    /**
    * Whether to format messages in MsBuild format
    */
    public Boolean LogFromMsBuild;
    /**
    * Whether to write progress markup in a format that can be parsed by other programs
    */
    public Boolean WriteProgressMarkup;
    /**
    * Whether to ignore the mutex
    */
    public Boolean NoMutex;
    /**
    * Whether to wait for the mutex rather than aborting immediately
    */
    public Boolean WaitMutex;
    /**
    * Whether to wait for the mutex rather than aborting immediately
    */
    public String RemoteIni;

    public def addParameters(List<String> parameters) {
        if (parameters.Verbose) {
            UATParameters.add('-verbose');
        }

        if (parameters.VeryVerbose) {
            UATParameters.add('-veryverbose');
        }

        if (parameters.NoPerforce) {
            UATParameters.add('-nop4');
        }

        if (parameters.LogFileName) {
            UATParameters.add('-logFileName=' + parameters.LogFileName);
        }

        if (parameters.LogTimestamps) {
            UATParameters.add('-logtimestamps');
        }

        if (parameters.LogFromMsBuild) {
            UATParameters.add('-logfrommsbuild');
        }

        if (parameters.WriteProgressMarkup) {
            UATParameters.add('-writeprogressmarkup');
        }

        if (parameters.NoMutex) {
            UATParameters.add('-nomutex');
        }

        if (parameters.WaitMutex) {
            UATParameters.add('-waitmutex');
        }

        if (parameters.WriteProgressMarkup) {
            UATParameters.add('-writeprogressmarkup');
        }
    }
}

class UnrealBuildCookRunParameters extends UnrealBuildToolGlobalOptions {
    /**
    * List of client configurations
    */
    public UnrealClientConfig ClientConfig;
    /**
    * Sets platforms to build for non-dedicated servers
    */
    public String TargetPlatform;
    /**
    * Package the project for the target platform
    */
    public String Project;
    public String ScriptsForProject;
    /**
    * Directory to archive the client to
    */
    public String ArchiveDirectory;
    /**
    * Disables Perforce functionality (default if not run on a build machine)
    */
    public Boolean NoPerforce;
    /**
    * Determines if the build is going to use cooked data
    */
    public Boolean Cook;
    /**
    * Put this build in a stage directory
    */
    public Boolean Stage;
    /**
    * Put this build in an archive directory
    */
    public Boolean Archive;
    /**
    * Package for distribution of the project
    */
    public Boolean Distribution;
    /**
    * If build step should be executed
    */
    public Boolean Build;
    /**
    * Package the project for the target platform
    */
    public Boolean Package;
    /**
    * Skips content under /Engine/Editor when cooking
    */
    public Boolean SkipCookingEditorContent;
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
