package Group_Issue1.buildTypes

import Group_Issue1.vcsRoots.Group_Issue1
import jetbrains.buildServer.configs.kotlin.v10.BuildType
import jetbrains.buildServer.configs.kotlin.v10.buildFeatures.vcsLabeling
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v10.triggers.finishBuildTrigger

object Group_Issue1_Publish : BuildType({
    uuid = "312035b7-4826-42e1-a9e2-4ed9812768e8"
    extId = "Group_Issue1_Publish"
    name = "Publish"

    vcs {
        root(Group_Issue1)
        cleanCheckout = true
    }

    steps {
        script {
            scriptContent = """echo "Publishing %teamcity.build.branch% ...""""
        }
    }

    triggers {
        finishBuildTrigger {
            buildTypeExtId = Group_Issue1_Test.extId
            successfulOnly = true
            branchFilter = """
                +:master
                +:release/*
                """.trimIndent()
        }
    }

    features {
        vcsLabeling {
            vcsRootExtId = Group_Issue1.extId
            labelingPattern = "%system.build.number%"
            successfulOnly = true
        }
    }
})
