from http.server import SimpleHTTPRequestHandler, HTTPServer

if __name__ == '__main__':
    httpd = HTTPServer(('127.0.0.1', 8000), lambda *_: SimpleHTTPRequestHandler(*_, directory='.'))
    httpd.serve_forever()
