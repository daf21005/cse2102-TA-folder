from flask import Flask, jsonify, request


def trial_division(n):
    factors = []
    # Handle 2 separately
    while n % 2 == 0:
        factors.append(2)
        n //= 2
    # Check odd numbers up to sqrt(n)
    p = 3
    while p * p <= n:
        while n % p == 0:
            factors.append(p)
        n //= p
    p += 2

    if n > 1:
        factors.append(n)
    return factors


# Define the Flask app
app = Flask(__name__)

def home():
  return "Hello from Flask!"

@app.route('/', methods=['GET'])
def root():
  print("Hello at the root")
  return jsonify({'main endpoint':'Ack'})

# curl -X POST -H "Content-Type: application/json" -d '{"inINT":12}' http://localhost:5000/calculate
@app.route('/calculate', methods=['POST'])
def submit():
  data = request.json
  number = data.get('inINT')
  myList = trial_division(number)
  # print(trial_division(number))
  return jsonify({'message': f'The numbers of the list are: {myList}'})

if __name__ == '__main__':
  app.run(host='0.0.0.0', port=5000, debug=True)