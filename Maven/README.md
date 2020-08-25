# Advantage of local repository in Maven

When the first time we are building any project, maven downloads the repository any stores a copy in .m2 folder.
From the next time if any project requires the same dependency maven simply uses it from local repository instead of downloading it again.
