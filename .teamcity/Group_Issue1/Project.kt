package Group_Issue1

import Group_Issue1.buildTypes.Group_Issue1_Build
import Group_Issue1.buildTypes.Group_Issue1_Publish
import Group_Issue1.buildTypes.Group_Issue1_Publish_Foo
import Group_Issue1.buildTypes.Group_Issue1_Test
import Group_Issue1.vcsRoots.Group_Issue1
import jetbrains.buildServer.configs.kotlin.v10.Project
import jetbrains.buildServer.configs.kotlin.v10.projectFeatures.VersionedSettings.BuildSettingsMode.PREFER_SETTINGS_FROM_VCS
import jetbrains.buildServer.configs.kotlin.v10.projectFeatures.VersionedSettings.Format.KOTLIN
import jetbrains.buildServer.configs.kotlin.v10.projectFeatures.VersionedSettings.Mode.ENABLED
import jetbrains.buildServer.configs.kotlin.v10.projectFeatures.versionedSettings

object Project : Project({
    uuid = "d9192413-1bb6-494a-a6dc-0d76dfa3e6ce"
    extId = "Group_Issue1"
    parentId = "Group"
    name = "Issue 1"

    vcsRoot(Group_Issue1)

    buildType(Group_Issue1_Build)
    buildType(Group_Issue1_Test)
    buildType(Group_Issue1_Publish)
    buildType(Group_Issue1_Publish_Foo)

    features {
        versionedSettings {
            id = "PROJECT_EXT_1"
            mode = ENABLED
            buildSettingsMode = PREFER_SETTINGS_FROM_VCS
            rootExtId = Group_Issue1.extId
            showChanges = false
            settingsFormat = KOTLIN
        }
    }

    buildTypesOrder = arrayListOf(
        Group_Issue1_Build,
        Group_Issue1_Test,
        Group_Issue1_Publish,
        Group_Issue1_Publish_Foo
    )
})
