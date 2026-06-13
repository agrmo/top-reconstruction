import astropy

from astropy.io import fits
hdul = fits.open('plates-dr12.fits')

hdul.info()

print(hdul[1].header)


