import matplotlib.pyplot

def q1():
    movies = [('Meet Pac Man', 3, 2, True),
              ('Pixels', 1, 1, False),
              ('The Ghostly Adventures', 4, 5, False),
              ('Pac Baby', 2, 4, True),
              ('Pac is Back', 3, 4, True)]

    x_noprofit_data = list()
    y_noprofit_data = list()

    x_profit_data = list()
    y_profit_data = list()

    for m in movies:
        
        
        if m[3]:
            x_profit_data.append(m[1])
            y_profit_data.append(m[2])
        else:
            x_noprofit_data.append(m[1])
            y_noprofit_data.append(m[2])

    matplotlib.pyplot.scatter(x_noprofit_data, y_noprofit_data, marker='+')
    matplotlib.pyplot.scatter(x_profit_data, y_profit_data, marker='_')
    
    gca = matplotlib.pyplot.gca()
    gca.set_xlabel('Critic A')
    gca.set_ylabel('Critic B')

    matplotlib.pyplot.show()

        

def main():
    q1()

if __name__ == '__main__':
    main()
