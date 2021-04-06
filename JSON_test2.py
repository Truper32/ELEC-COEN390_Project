from flask import Flask
from flask import jsonify
app = Flask(__name__)

@app.route('/')
def send():
    return jsonify(name = 'Karim Rhoualem', ID=26603157)

# Run from command line using flask run --host="<IP Address>" --port=<portNumber>
if __name__ == "__main__":
    app.run(host="192.168.2.135", port= "5000")

