DESCRIPTION = "Plugins for a virtual keyboard for touch-screen based user interfaces"
HOMEPAGE = "https://wiki.maliit.org/Main_Page"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f29b21caa8e460097bfad9c026a33621"

inherit autotools qt4x11

DEPENDS = "maliit-framework"

SRC_URI = "git://gitorious.org/maliit/maliit-plugins.git;branch=master"

SRCREV = "0760e585df494b394df1b887e5138ffef19c481f"
PV = "0.92.3+git${SRCPV}"

EXTRA_QMAKEVARS_PRE = "\
    PREFIX=${prefix} \
    LIBDIR=${libdir} \
    "

FILES_${PN} += "\
    ${libdir}/maliit \
    ${datadir} \
    "

FILES_${PN}-dbg += "\
    ${libdir}/maliit/plugins-*/.debug \
    "

S= "${WORKDIR}/git"

do_install() {
  cd ${S} && (INSTALL_ROOT=${D} oe_runmake install)
}
