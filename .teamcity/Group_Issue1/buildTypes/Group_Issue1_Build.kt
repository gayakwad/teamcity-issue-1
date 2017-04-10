package Group_Issue1.buildTypes

import Group_Issue1.vcsRoots.Group_Issue1
import jetbrains.buildServer.configs.kotlin.v10.BuildType
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v10.triggers.vcs

object Group_Issue1_Build : BuildType({
    uuid = "275303c2-9a8d-4c7b-a386-15a8a4b820dc"
    extId = "Group_Issue1_Build"
    name = "Build"

    vcs {
        root(Group_Issue1)
        cleanCheckout = true
    }

    steps {
        script {
            scriptContent = """echo "Building %teamcity.build.branch% ...""""
        }
    }

    triggers {
        vcs {
            perCheckinTriggering = true
        }
    }

})
