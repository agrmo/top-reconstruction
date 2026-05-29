from ordnen.schnell.schnellordne import schnellordne

# python -m ordnen.schnell.main

def main():
    l = [9,5,3,1,12,531,524,635,791]
    l_geordnet = schnellordne(l)
    print(l_geordnet)

if __name__ == "__main__":
    main()
