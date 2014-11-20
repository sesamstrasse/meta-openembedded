DESCRIPTION = "GNU libmicrohttpd is a small C library that is supposed to make it easy to run an HTTP server as part of another application."
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=9331186f4f80db7da0e724bdd6554ee5"

DEPENDS = "libgcrypt curl"

SRC_URI = "ftp://ftp.nluug.nl/pub/gnu/libmicrohttpd/libmicrohttpd-${PV}.tar.gz"
SRC_URI[md5sum] = "b72efbfe7f290846015d460aea7091fe"
SRC_URI[sha256sum] = "8df2b4dd863c98799a4775a530d905363fbc02fec850af9094da890b28b9e721"

inherit autotools lib_package

do_compile_append() {
	sed -i s:-L${STAGING_LIBDIR}::g libmicrohttpd.pc
}
