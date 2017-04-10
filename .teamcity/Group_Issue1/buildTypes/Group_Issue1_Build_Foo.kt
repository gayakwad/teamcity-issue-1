package Group_Issue1.buildTypes

import Group_Issue1.vcsRoots.Group_Issue1
import jetbrains.buildServer.configs.kotlin.v10.BuildType
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v10.triggers.vcs

object Group_Issue1_Build_Foo : BuildType({
    uuid = "1f0e189d-7266-4f69-acfd-e3a6dae32756"
    extId = "Group_Issue1_Build_Foo"
    name = "Build Foo"

    vcs {
        root(Group_Issue1)
        cleanCheckout = true
    }

    steps {
        script {
            scriptContent = """echo "Foo Building %teamcity.build.branch% ...""""
        }
    }

    triggers {
        vcs {
            perCheckinTriggering = true
        }
    }

})
