package Group_Issue1.vcsRoots

import jetbrains.buildServer.configs.kotlin.v10.vcs.GitVcsRoot

object Group_Issue1 : GitVcsRoot({
    uuid = "09d05610-5493-4e2d-953c-a4f253c1fed9"
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
