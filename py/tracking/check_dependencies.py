from os.path import exists

# Check dependencies for ACTS

dependencies = ['/usr/bin/make', '/usr/bin/cmake', '/usr/bin/g++', '/usr/bin/gcc', '/usr/bin/ld', '/usr/include/X11/Xlib.h', '/usr/lib/libX11.so', '/usr/include/X11/xpm.h', '/usr/lib/libXpm.so', '/usr/include/X11/Xft/Xft.h', '/usr/lib/libXft.so', '/usr/include/X11/extensions/shape.h', '/usr/lib/libXext.so', '/usr/include/openssl/pem.h', '/usr/lib/libssl.so', '/usr/lib/libcrypto.so', '/usr/include/pcre.h', '/usr/bin/pcre-config', '/usr/include/GL/glew.h', '/usr/lib/libGLEW.so', '/usr/lib/libgsl.so', '/usr/lib/libxml2.so', '/usr/include/libAfterImage', '/usr/lib/libOpenCL.so', '/lib/libgl2ps.so', '/usr/lib/libfftw3.so', '/usr/lib/libcfitsio.so', '/usr/include/uuid/uuid.h', '/usr/lib/libblas.so', '/usr/lib/liblzma.so', '/usr/lib/libxxhash.so', '/usr/lib/libzstd.so', '/usr/lib/liblz4.so', '/usr/lib/libbz2.so', '/usr/bin/f95', '/usr/lib/libz.so', '/usr/bin/c++']

def main():
    for d in dependencies:
        e = exists(d)
        if (e):
            print('Exists', d)
        else:
            print('Does not exist', d)

if __name__ == '__main__':
    main()
