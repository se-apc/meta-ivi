DESCRIPTION = "GENIVI P1 Abstract components (AC)"
LICENSE = "MIT"

inherit packagegroup

PACKAGES = "\
    packagegroup-abstract-component-p1 \
"

ALLOW_EMPTY:${PN} = "1"

RDEPENDS:${PN} += "\
    bluez5 \
    bluez5-obex \
    glibc \
    libbluetooth-plugins-service \
    ofono \
    wayland-ivi-extension \
    weston weston-examples \
"
