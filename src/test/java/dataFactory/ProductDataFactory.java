package dataFactory;

import pojo.ComponentPojo;
import pojo.ProductPojo;

import java.util.ArrayList;
import java.util.List;

public class ProductDataFactory {
    public static ProductPojo createCommonProductWithValueEqualTo (double value) {
        ProductPojo product = new ProductPojo();
        product.setProdutoNome("PS2");
        product.setProdutoValor(value);

        List<String> colors = new ArrayList<>();
        colors.add("preto");
        colors.add("branco");

        product.setProdutoCores(colors);
        product.setProdutoUrlMock("");

        List<ComponentPojo> components = new ArrayList<>();

        ComponentPojo component = new ComponentPojo();
        component.setComponenteNome("Controle");
        component.setComponenteQuantidade(1);

        components.add(component);

        product.setComponentes(components);

        return product;
    }
}
