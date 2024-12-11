package br.edu.utfpr.td.tsi.calculadora.imposto;

import br.edu.utfpr.td.tsi.calculadora.imposto.modelo.calculation.CalculationTaxAcre;
import br.edu.utfpr.td.tsi.calculadora.imposto.modelo.calculation.CalculationTaxAlagoas;
import br.edu.utfpr.td.tsi.calculadora.imposto.modelo.calculation.CalculationTaxAmapa;
import br.edu.utfpr.td.tsi.calculadora.imposto.modelo.calculation.CalculationTaxAmazonas;
import br.edu.utfpr.td.tsi.calculadora.imposto.modelo.calculation.CalculationTaxBahia;
import br.edu.utfpr.td.tsi.calculadora.imposto.modelo.calculation.CalculationTaxCeara;
import br.edu.utfpr.td.tsi.calculadora.imposto.modelo.calculation.CalculationTaxDistritoFederal;
import br.edu.utfpr.td.tsi.calculadora.imposto.modelo.calculation.CalculationTaxEspiritoSanto;
import br.edu.utfpr.td.tsi.calculadora.imposto.modelo.calculation.CalculationTaxGoias;
import br.edu.utfpr.td.tsi.calculadora.imposto.modelo.calculation.CalculationTaxMaranhao;
import br.edu.utfpr.td.tsi.calculadora.imposto.modelo.calculation.CalculationTaxMatoGrosso;
import br.edu.utfpr.td.tsi.calculadora.imposto.modelo.calculation.CalculationTaxMatoGrossoSul;
import br.edu.utfpr.td.tsi.calculadora.imposto.modelo.calculation.CalculationTaxMinasGerais;
import br.edu.utfpr.td.tsi.calculadora.imposto.modelo.calculation.CalculationTaxPara;
import br.edu.utfpr.td.tsi.calculadora.imposto.modelo.calculation.CalculationTaxParaiba;
import br.edu.utfpr.td.tsi.calculadora.imposto.modelo.calculation.CalculationTaxParana;
import br.edu.utfpr.td.tsi.calculadora.imposto.modelo.calculation.CalculationTaxPernanbuco;
import br.edu.utfpr.td.tsi.calculadora.imposto.modelo.calculation.CalculationTaxPiaui;
import br.edu.utfpr.td.tsi.calculadora.imposto.modelo.calculation.CalculationTaxRioGrandeNorte;
import br.edu.utfpr.td.tsi.calculadora.imposto.modelo.calculation.CalculationTaxRioGrandeSul;
import br.edu.utfpr.td.tsi.calculadora.imposto.modelo.calculation.CalculationTaxRioJaneiro;
import br.edu.utfpr.td.tsi.calculadora.imposto.modelo.calculation.CalculationTaxRondonia;
import br.edu.utfpr.td.tsi.calculadora.imposto.modelo.calculation.CalculationTaxRoraima;
import br.edu.utfpr.td.tsi.calculadora.imposto.modelo.calculation.CalculationTaxSantaCatarina;
import br.edu.utfpr.td.tsi.calculadora.imposto.modelo.calculation.CalculationTaxSaoPaulo;
import br.edu.utfpr.td.tsi.calculadora.imposto.modelo.calculation.CalculationTaxSergipe;
import br.edu.utfpr.td.tsi.calculadora.imposto.modelo.calculation.CalculationTaxTocantins;
import br.edu.utfpr.td.tsi.calculadora.imposto.modelo.calculation.TaxCalculation;

public enum FederalUnit {
    AMAZONAS{
		@Override
		public TaxCalculation taxCalculation() {
			return new CalculationTaxAmazonas();
		}
	},
	ALAGOAS {
		@Override
		public TaxCalculation taxCalculation() {
			return new CalculationTaxAlagoas();
		}
	},
	ACRE {
		@Override
		public TaxCalculation taxCalculation() {
			return new CalculationTaxAcre();
		}
	},
	AMAPA {
		@Override
		public TaxCalculation taxCalculation() {
			return new CalculationTaxAmapa();
		}
	},
	BAHIA {
		@Override
		public TaxCalculation taxCalculation() {
			return new CalculationTaxBahia();
		}
	},
	PARA {
		@Override
		public TaxCalculation taxCalculation() {
			return new CalculationTaxPara();
		}
	},
	MATO_GROSSO {
		@Override
		public TaxCalculation taxCalculation() {
			return new CalculationTaxMatoGrosso();
		}
	},
	MINAS_GERAIS {
		@Override
		public TaxCalculation taxCalculation() {
			return new CalculationTaxMinasGerais();
		}
	},
	MATO_GROSSO_DO_SUL{
		@Override
		public TaxCalculation taxCalculation() {
			return new CalculationTaxMatoGrossoSul();
		}
	},
	GOIAS {
		@Override
		public TaxCalculation taxCalculation() {
			return new CalculationTaxGoias();
		}
	},
	MARANHAO {
		@Override
		public TaxCalculation taxCalculation() {
			return new CalculationTaxMaranhao();
		}
	},
	RIO_GRANDE_DO_SUL {
		@Override
		public TaxCalculation taxCalculation() {
			return new CalculationTaxRioGrandeSul();
		}
	}, 
	TOCANTINS {
		@Override
		public TaxCalculation taxCalculation() {
			return new CalculationTaxTocantins();
		}
	},
	PIAUI {
		@Override
		public TaxCalculation taxCalculation() {
			return new CalculationTaxPiaui();
		}
	},
	SAO_PAULO {
		@Override
		public TaxCalculation taxCalculation() {
			return new CalculationTaxSaoPaulo();
		}
	}, 
	RONDONIA {
		@Override
		public TaxCalculation taxCalculation() {
			return new CalculationTaxRondonia();
		}
	},
	RORAIMA {
		@Override
		public TaxCalculation taxCalculation() {
			return new CalculationTaxRoraima();
		}
	},
	PARANA {
		@Override
		public TaxCalculation taxCalculation() {
			return new CalculationTaxParana();
		}
	},
	CEARA {
		@Override
		public TaxCalculation taxCalculation() {
			return new CalculationTaxCeara();
		}
	},
	PERNAMBUCO {
		@Override
		public TaxCalculation taxCalculation() {
			return new CalculationTaxPernanbuco();
		}
	},
	SANTA_CATARINA {
		@Override
		public TaxCalculation taxCalculation() {
			return new CalculationTaxSantaCatarina();
		}
	},
	PARAIBA {
		@Override
		public TaxCalculation taxCalculation() {
			return new CalculationTaxParaiba();
		}
	},
	RIO_GRANDE_DO_NORTE {
		@Override
		public TaxCalculation taxCalculation() {
			return new CalculationTaxRioGrandeNorte();
		}
	},
	ESPIRITO_SANTO {
		@Override
		public TaxCalculation taxCalculation() {
			return new CalculationTaxEspiritoSanto();
		}
	},
	RIO_DE_JANEIRO {
		@Override
		public TaxCalculation taxCalculation() {
			return new CalculationTaxRioJaneiro();
		}
	},
	SERGIPE {
		@Override
		public TaxCalculation taxCalculation() {
			return new CalculationTaxSergipe();
		}
	},
	DISTRITO_FEDERAL {
		@Override
		public TaxCalculation taxCalculation() {
			return new CalculationTaxDistritoFederal();
		}
	};

	public abstract TaxCalculation taxCalculation();
}
