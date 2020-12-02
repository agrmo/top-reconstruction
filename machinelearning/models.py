import nn


# Agustin

# Hello and welcome to PA4!

# Q1 takes about 5 seconds
# Q2 takes about 30 seconds
# Q3 takes about 3 minutes

class PerceptronModel(object):
    def __init__(self, dimensions):
        """
        Initialize a new Perceptron instance.

        A perceptron classifies data points as either belonging to a particular
        class (+1) or not (-1). `dimensions` is the dimensionality of the data.
        For example, dimensions=2 would mean that the perceptron must classify
        2D points.
        """
        self.w = nn.Parameter(1, dimensions)

    def get_weights(self):
        """
        Return a Parameter instance with the current weights of the perceptron.
        """
        return self.w

    def run(self, x):
        """
        Calculates the score assigned by the perceptron to a data point x.

        Inputs:
            x: a node with shape (1 x dimensions)
        Returns: a node containing a single number (the score)
        """
        return nn.DotProduct(x, self.w)

    def classify(self, scalar):        
        if scalar >= 0:
            return 1
        else:
            return -1

    def get_prediction(self, x):
        """
        Calculates the predicted class for a single data point `x`.

        Returns: 1 or -1
        """
        dotproduct = self.run(x)
        scalar = nn.as_scalar(dotproduct)

        return self.classify(scalar)

    def onepass_train(self, dataset):
        at_least_one_misclassified = False
        batch_size = 1
        for constant_training_x, constant_training_y in dataset.iterate_once(batch_size):
            scalar_predicted_y = self.get_prediction(constant_training_x)

            if scalar_predicted_y != nn.as_scalar(constant_training_y):
                at_least_one_misclassified = True
                self.w.update(constant_training_x, nn.as_scalar(constant_training_y))

        return at_least_one_misclassified

    def train(self, dataset):
        """
        Train the perceptron until convergence.
        """
        at_least_one_misclassified = self.onepass_train(dataset)

        while (at_least_one_misclassified):
            at_least_one_misclassified = self.onepass_train(dataset)
            
        

class RegressionModel(object):
    """
    A neural network model for approximating a function that maps from real
    numbers to real numbers. The network should be sufficiently large to be able
    to approximate sin(x) on the interval [-2pi, 2pi] to reasonable precision.
    """
    def __init__(self):
        # Initialize your model parameters here
        self.batchsize = 5
        self.m1 = nn.Parameter(1, 80)
        self.b1 = nn.Parameter(1, 80)
        self.m2 = nn.Parameter(80, 1)
        self.b2 = nn.Parameter(1, 1)

    def run(self, x):
        """
        Runs the model for a batch of examples.

        Inputs:
            x: a node with shape (batch_size x 1)
        Returns:
            A node with shape (batch_size x 1) containing predicted y-values
        """
        xm1 = nn.Linear(x, self.m1)
        addbias1 = nn.AddBias(xm1, self.b1)

        # Compute a rectified linear unit, max(x,0).
        layer1_relu = nn.ReLU(addbias1)
        
        xm2 = nn.Linear(layer1_relu, self.m2)
        addbias2 = nn.AddBias(xm2, self.b2)

        return addbias2
        
    
    def get_loss(self, x, y):
        """
        Computes the loss for a batch of examples.

        Inputs:
            x: a node with shape (batch_size x 1)
            y: a node with shape (batch_size x 1), containing the true y-values
                to be used for training
        Returns: a loss node
        """
        predicted_y = self.run(x)
        loss = nn.SquareLoss(predicted_y, y)
        return loss

    def onepass_train(self, dataset):

        for constant_training_x, constant_training_y in dataset.iterate_once(self.batchsize):
            loss = self.get_loss(constant_training_x, constant_training_y)
            grad_wrt_m1, grad_wrt_b1, grad_wrt_m2, grad_wrt_b2 = nn.gradients(loss, [self.m1, self.b1, self.m2, self.b2])
            self.m1.update(grad_wrt_m1, -0.004)
            self.b1.update(grad_wrt_b1, -0.004)
            self.m2.update(grad_wrt_m2, -0.004)
            self.b2.update(grad_wrt_b2, -0.004)

        return loss

    def train(self, dataset):
        """
        Trains the model.
        """
        loss = nn.as_scalar(self.onepass_train(dataset))
        
        while (loss > 0.019):
            loss = nn.as_scalar(self.onepass_train(dataset))
        
class DigitClassificationModel(object):
    """
    A model for handwritten digit classification using the MNIST dataset.

    Each handwritten digit is a 28x28 pixel grayscale image, which is flattened
    into a 784-dimensional vector for the purposes of this model. Each entry in
    the vector is a floating point number between 0 and 1.

    The goal is to sort each digit into one of 10 classes (number 0 through 9).

    (See RegressionModel for more information about the APIs of different
    methods here. We recommend that you implement the RegressionModel before
    working on this part of the project.)
    """
    def __init__(self):
        # Initialize your model parameters here
        self.batchsize = 30
        self.m1 = nn.Parameter(784, 200)
        self.b1 = nn.Parameter(1, 200)
        self.m2 = nn.Parameter(200, 10)
        self.b2 = nn.Parameter(1, 10)

    def run(self, x):
        """
        Runs the model for a batch of examples.

        Your model should predict a node with shape (batch_size x 10),
        containing scores. Higher scores correspond to greater probability of
        the image belonging to a particular class.

        Inputs:
            x: a node with shape (batch_size x 784)
        Output:
            A node with shape (batch_size x 10) containing predicted scores
                (also called logits)
        """
        xm1 = nn.Linear(x, self.m1)
        addbias1 = nn.AddBias(xm1, self.b1)

        # Compute a rectified linear unit, max(x,0).
        layer1_relu = nn.ReLU(addbias1)
        
        xm2 = nn.Linear(layer1_relu, self.m2)
        addbias2 = nn.AddBias(xm2, self.b2)

        return addbias2

    def get_loss(self, x, y):
        """
        Computes the loss for a batch of examples.

        The correct labels `y` are represented as a node with shape
        (batch_size x 10). Each row is a one-hot vector encoding the correct
        digit class (0-9).

        Inputs:
            x: a node with shape (batch_size x 784)
            y: a node with shape (batch_size x 10)
        Returns: a loss node
        """
        predicted_y = self.run(x)
        loss = nn.SoftmaxLoss(predicted_y, y)
        return loss


    def onepass_train(self, dataset):

        for constant_training_x, constant_training_y in dataset.iterate_once(self.batchsize):
            loss = self.get_loss(constant_training_x, constant_training_y)
            grad_wrt_m1, grad_wrt_b1, grad_wrt_m2, grad_wrt_b2 = nn.gradients(loss, [self.m1, self.b1, self.m2, self.b2])
            # .09 epoch 5 batch 5 is about .975
            # .0005 epoch 5 batch 10 is about .95
            # 0.07 epoch 5 batch 10 depth 200 is about .971
            # -0.05 200 5 is best so far
            # 
            self.m1.update(grad_wrt_m1, -0.4)
            self.b1.update(grad_wrt_b1, -0.4)
            self.m2.update(grad_wrt_m2, -0.4)
            self.b2.update(grad_wrt_b2, -0.4)

        return loss
    

    def train(self, dataset):
        """
        Trains the model.
        """
        accuracy = 0.0
        
        while (accuracy < 0.975):
            accuracy = dataset.get_validation_accuracy()
            self.onepass_train(dataset)


class LanguageIDModel(object):
    """
    A model for language identification at a single-word granularity.

    (See RegressionModel for more information about the APIs of different
    methods here. We recommend that you implement the RegressionModel before
    working on this part of the project.)
    """
    def __init__(self):
        # Our dataset contains words from five different languages, and the
        # combined alphabets of the five languages contain a total of 47 unique
        # characters.
        # You can refer to self.num_chars or len(self.languages) in your code
        self.num_chars = 47
        self.languages = ["English", "Spanish", "Finnish", "Dutch", "Polish"]
        

    def run(self, xs):
        """
        Runs the model for a batch of examples.

        Although words have different lengths, our data processing guarantees
        that within a single batch, all words will be of the same length (L).

        Here `xs` will be a list of length L. Each element of `xs` will be a
        node with shape (batch_size x self.num_chars), where every row in the
        array is a one-hot vector encoding of a character. For example, if we
        have a batch of 8 three-letter words where the last word is "cat", then
        xs[1] will be a node that contains a 1 at position (7, 0). Here the
        index 7 reflects the fact that "cat" is the last word in the batch, and
        the index 0 reflects the fact that the letter "a" is the inital (0th)
        letter of our combined alphabet for this task.

        Your model should use a Recurrent Neural Network to summarize the list
        `xs` into a single node of shape (batch_size x hidden_size), for your
        choice of hidden_size. It should then calculate a node of shape
        (batch_size x 5) containing scores, where higher scores correspond to
        greater probability of the word originating from a particular language.

        Inputs:
            xs: a list with L elements (one per character), where each element
                is a node with shape (batch_size x self.num_chars)
        Returns:
            A node with shape (batch_size x 5) containing predicted scores
                (also called logits)
        """

    def get_loss(self, xs, y):
        """
        Computes the loss for a batch of examples.

        The correct labels `y` are represented as a node with shape
        (batch_size x 5). Each row is a one-hot vector encoding the correct
        language.

        Inputs:
            xs: a list with L elements (one per character), where each element
                is a node with shape (batch_size x self.num_chars)
            y: a node with shape (batch_size x 5)
        Returns: a loss node
        """
    

    def train(self, dataset):
        """
        Trains the model.
        """
