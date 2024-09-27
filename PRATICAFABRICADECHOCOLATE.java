/* Pratica 1 - Singleton 
    Dupla: Igor Carvalho Braz -- RA: 42021158
            Matheus Magalhães Alves Lopes -- RA: 4231922738*/ 

class CaldeiraChocolate:
    _instancia = None
    @staticmethod
    def obterInstancia():
        if CaldeiraChocolate._instancia is None:
            CaldeiraChocolate._instancia = CaldeiraChocolate()
        return CaldeiraChocolate._instancia

    def __init__(self):
        self.vazia = True
        self.fervida = False

    def preencher(self):
        if self.vazia:
            self.vazia = False
            self.fervida = False
            print("Caldeira preenchida com chocolate e leite.")
        else:
            print("Caldeira já está cheia.")

    def ferver(self):
        if not self.vazia and not self.fervida:
            self.fervida = True
            print("Mistura em ebulição.")
        elif self.vazia:
            print("Caldeira vazia, impossível ferver.")
        elif self.fervida:
            print("Mistura já fervida.")

    def drenar(self):
        if not self.vazia and self.fervida:
            self.vazia = True
            print("Mistura fervida drenada.")
        elif self.vazia:
            print("Caldeira vazia, impossível drenar.")
        elif not self.fervida:
            print("Mistura não foi fervida, impossível drenar.")

class FabricaDeChocolate:
    def __init__(self):
        self.caldeira = CaldeiraChocolate.obterInstancia()
    def operar(self):
        self.caldeira.preencher()
        self.caldeira.ferver()
        self.caldeira.drenar()
        self.caldeira.drenar()
        self.caldeira.ferver()
        self.caldeira.preencher()
        self.caldeira.preencher()
        self.caldeira.ferver()
        self.caldeira.drenar()

fabrica = FabricaDeChocolate()
fabrica.operar()
