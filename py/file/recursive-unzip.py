import os
import io
import zipfile
import tarfile
import pathlib

def extract(filename, dirpath):
    extractpath = dirpath / (filename + 'dir')
    os.mkdir(extractpath)
    
    if filename.endswith('zip'):
        z = zipfile.ZipFile(dirpath / filename)
        z.extractall(extractpath)
        files = os.listdir(extractpath)
        for f in files:
            extract(f, extractpath)

    elif filename.endswith('xz'):
        print('opening', str(dirpath), filename)
        t = tarfile.open(dirpath / filename)
        t.extractall(extractpath)
        files = os.listdir(extractpath)
        for f in files:
            extract(f, extractpath)

    else:
        print(filename + 'does not end with zip or xz.')


def extract_string(filename, dirname):
    extract(filename, pathlib.Path(dirname))


extract_string('texlive-core-2022.63035-src.zip', '.')

