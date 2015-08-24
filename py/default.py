from time import time

CHARS = '0123456789ABCDEFGHIJKLMNOPQRSTUV'

def chunks(l, n):
    return [l[i:i+n] for i in range(0, len(l), n)]

def format_field(value, bits):
    enc_value = bin(int(value))[2:]
    return '%s%s' % ('0'*(bits-len(enc_value)), enc_value)

def generate_message(bits, *args):
    """ Encode a message
    We need to pass the list of int values that are appended and their size in bits
    """
    step1 = [format_field(x[0], x[1]) for x in zip(args, bits)]
    #print step1
    step2 = [int(x, base=2) for x in chunks(''.join(step1), 5)]
    #print step2
    step3 = [CHARS[x] for x in step2]
    return ''.join(step3)

if __name__ == '__main__':
    start = time()
    bits = [10, 3, 3, 3, 3, 7, 10, 6]

    res = generate_message(bits, '1', '0', '0', '0', '0', '30', '10', '9')
    print res