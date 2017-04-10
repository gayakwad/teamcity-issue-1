package Group_Issue1.vcsRoots

import jetbrains.buildServer.configs.kotlin.v10.vcs.GitVcsRoot

object Group_Issue1 : GitVcsRoot({
    uuid = "aac6dc48-edb8-4f4d-a51b-8f8b03041e2f"
    extId = "Group_Issue1"
    name = "Group_Issue1"
    url = "git@github.com:gayakwad/teamcity-issue-1.git"
    pushUrl = "git@github.com:gayakwad/teamcity-issue-1.git"
    authMethod = uploadedKey {
        uploadedKey = "VSC Key"
    }
    agentCleanPolicy = AgentCleanPolicy.ALWAYS
    branchSpec = """
        +:refs/heads/(master)
        +:refs/heads/(release/*)
        +:refs/(pull-requests/*)/from
    """.trimIndent()
})
