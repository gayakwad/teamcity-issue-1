package Group_Issue1.buildTypes

import Group_Issue1.vcsRoots.Group_Issue1
import jetbrains.buildServer.configs.kotlin.v10.BuildType
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v10.triggers.finishBuildTrigger

object Group_Issue1_Test : BuildType({
    uuid = "44f01df4-6149-4eac-988c-f2a70e342a4d"
    extId = "Group_Issue1_Test"
    name = "Test"

    vcs {
        root(Group_Issue1)
        cleanCheckout = true
    }

    steps {
        script {
            scriptContent = """echo "Testing %teamcity.build.branch% ...""""
        }
    }

    triggers {
        finishBuildTrigger {
            buildTypeExtId = Group_Issue1_Build.extId
            successfulOnly = true
            branchFilter = """
                +:*
                """.trimIndent()
        }
    }

})
