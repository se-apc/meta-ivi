#
# Contains changes by Wind River Systems, 2013-08-08
# Copyright (c) 2013 Wind River Systems, Inc.
# Copyright (C) 2007 OpenedHand Ltd.
#
# derived from oe-core: meta/recipes-core/packagegroups/packagegroup-core-boot.bb

SUMMARY = "Minimal boot requirements"
DESCRIPTION = "The minimal set of packages required to boot the system"
LICENSE = "MIT"
DEPENDS = "virtual/kernel"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

#
# Set by the machine configuration with packages essential for device bootup
#
MACHINE_ESSENTIAL_EXTRA_RDEPENDS ?= ""
MACHINE_ESSENTIAL_EXTRA_RRECOMMENDS ?= ""

# Distro can override the following VIRTUAL-RUNTIME providers:
VIRTUAL-RUNTIME:dev_manager ?= "udev"
VIRTUAL-RUNTIME:login_manager ?= "busybox"
VIRTUAL-RUNTIME:init_manager ?= "systemd"
VIRTUAL-RUNTIME:initscripts ?= ""
VIRTUAL-RUNTIME:keymaps ?= "keymaps"

RDEPENDS:${PN} = "\
    ${@bb.utils.contains("MACHINE_FEATURES", "keyboard", "${VIRTUAL-RUNTIME:keymaps}", "", d)} \
    ${MACHINE_ESSENTIAL_EXTRA_RDEPENDS} \
    ${VIRTUAL-RUNTIME:dev_manager} \
    ${VIRTUAL-RUNTIME:init_manager} \
    ${VIRTUAL-RUNTIME:initscripts} \
    ${VIRTUAL-RUNTIME:login_manager} \
    ${VIRTUAL-RUNTIME:update-alternatives} \
    base-files \
    base-passwd \
    busybox \
    kmod \
    netbase \
    procps \
    util-linux-mount \
"

RRECOMMENDS:${PN} = "\
    ${MACHINE_ESSENTIAL_EXTRA_RRECOMMENDS} \
"
