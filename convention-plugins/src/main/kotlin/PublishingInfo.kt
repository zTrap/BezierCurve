object PublishingInfo {
    const val BASE_ARTIFACT_NAME = "beziercurve"
    const val BASE_REPO_BUCKET = "zTrap/$BASE_ARTIFACT_NAME"
    const val BASE_REPO_URL = "https://github.com/$BASE_REPO_BUCKET"

    const val GROUP = "ru.ztrap"

    object Repo {
        const val URL = BASE_REPO_URL
    }

    object Scm {
        const val URL = BASE_REPO_URL
        const val CONNECTION = "scm:git@github.com:${BASE_REPO_BUCKET}.git"
        const val DEV_CONNECTION = "scm:git@github.com:${BASE_REPO_BUCKET}.git"
    }

    object License {
        const val NAME = "the apache software license, version 2.0"
        const val URL = "http://www.apache.org/licenses/license-2.0.txt"
        const val DIST = "repo"
    }

    object Developer {
        const val ID = "ztrap"
        const val NAME = "peter gulko"
        const val EMAIL = "ztrap.developer@gmail.com"
    }

    object Artifact {
        const val ID = BASE_ARTIFACT_NAME
        const val NAME = "Bezier curves creator"
        const val DESCRIPTION = "The simple multiplatform helper for build Bezier curves"
        const val VERSION = "1.0.3"
    }
}