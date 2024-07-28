
# Jenkins CI/CD Pipeline for Django Application

## General Settings

### Description
**A Django CI/CD Pipeline**: This is a brief description of the pipeline. It states that the pipeline is responsible for building and deploying a Django application.

### Discard Old Builds
**Discard old builds**: This option allows you to configure Jenkins to automatically delete old build records to save disk space. You can set criteria such as the maximum number of builds to keep or the maximum amount of time to keep builds.

### Do Not Allow Concurrent Builds
**Do not allow concurrent builds**: This option prevents multiple builds of the same project from running simultaneously. This can be useful to avoid conflicts or resource contention.

### Do Not Allow the Pipeline to Resume if the Controller Restarts
**Do not allow the pipeline to resume if the controller restarts**: This option ensures that if Jenkins restarts, the pipeline won't automatically resume from where it left off. This can help avoid potential issues from partial states.

## GitHub Project

### Project URL
**[https://github.com/LondheShubham153/django-notes-app.git](https://github.com/LondheShubham153/django-notes-app.git)**: This is the URL of the GitHub repository containing the Django application code. Jenkins will pull the code from this repository to build and deploy.

## Advanced

### Display Name
**Django Notes App**: This is a user-friendly name for the project in Jenkins. It helps to easily identify the project in the Jenkins interface.

### Pipeline Speed/Durability Override
**Pipeline speed/durability override**: This setting allows you to override default pipeline settings related to speed and durability. For example, you might prioritize speed over durability in a testing environment.

### Preserve Stashes from Completed Builds
**Preserve stashes from completed builds**: This option allows you to keep temporary files (stashes) created during the build process. These files can be useful for debugging or for use in subsequent builds.

### This Project is Parameterized
**This project is parameterized**: Enabling this allows you to define parameters that can be passed to the build. Parameters can be used to customize the build process, such as specifying different environments or configurations.

### Throttle Builds
**Throttle builds**: This option allows you to limit the number of concurrent builds across all projects or specific categories. It's useful for managing resource usage and avoiding overloading the Jenkins server.

## Build Triggers

### Build After Other Projects Are Built
**Build after other projects are built**: This trigger allows the pipeline to start building only after specified projects have been built. It can be used to create build dependencies between projects.

### Build Periodically
**Build periodically**: This trigger enables scheduled builds at regular intervals (e.g., nightly builds). You can specify the schedule using a cron syntax.

### GitHub Hook Trigger for GITScm Polling
**GitHub hook trigger for GITScm polling**: This trigger initiates a build whenever a change is detected in the GitHub repository. It's often used to automatically build and deploy code changes pushed to the repository.

### Poll SCM
**Poll SCM**: This trigger checks the source control management (SCM) system (e.g., Git) for changes at regular intervals. If changes are detected, a build is triggered. The interval is specified using cron syntax.

### Quiet Period
**Quiet period**: This setting defines a delay (in seconds) before the build is started after a trigger is received. It can be useful to batch multiple changes together.

### Trigger Builds Remotely (e.g., from Scripts)
**Trigger builds remotely**: This option allows builds to be triggered from external scripts or systems using an authentication token. It can be useful for integrating Jenkins with other automation tools or workflows.
