DESCRIPTION = "GENIVI P2 Specific components (SC)"
LICENSE = "MIT"
PR = "r1"

inherit packagegroup

PACKAGES = "\
    packagegroup-specific-component-p2 \
"

ALLOW_EMPTY:${PN} = "1"

RDEPENDS:${PN} += "\
    common-api-c++-dbus \
    common-api-c++-someip \
    fuse \
    pulseaudio-server \
    quota \
    sqlite3 \
    vsomeip \
"
