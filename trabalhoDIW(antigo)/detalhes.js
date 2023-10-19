function obterValorParametro(nomeParametro) {
    const urlParams = new URLSearchParams(window.location.search);
    return urlParams.get(nomeParametro);
  }

  const produtos = [
    {
      id: 0,
      title: 'Vinil-Hozier-Wasteland Baby!',
      price: 165.00,
      category: 'Artistas masculinos',
      image: 'fotossite/hozierwasteland.jpg',
      rating: 4.5,
      description: 'Este novo álbum de Hozier é muito bom, apesar de ter boas variações, é um trabalho mais tranquilo e leve com letras ótimas. A composição dos versos, inclusive, merece bastante atenção, pois muitas trazem mensagens positivas e são bem interessantes.'
    },
    {
      id: 1,
      title: 'Vinil-Rina Sawayama-SAWAYAMA',
      price: 160.99,
      category: 'Artistas femininas',
      image: 'fotossite/rinasawayama.jpg',
      rating: 4.0,
      description: 'SAWAYAMA é, acima de tudo, sobre coragem. É um álbum que quebra barreiras, molda gêneros, discute os pecados determinados por uma sociedade que falha em tentar definir pessoas a um único e inflexível regulamento'
    },
    {
        id: 2,
        title: 'Vinil-Kali Uchis-Isolation',
        price: 155.66,
        category: 'Artistas femininas',
        image: 'fotossite/kuisolation.jpg',
        rating: 4.3,
        description: 'A narrativa também garante o disco como um pacote. As letras tratam, basicamente, sobre paixões, desilusões e sentimentos que Kali Uchis colocam à flor da pele para que possamos sentir. E, diante deste doce furacão, é possível sentir. Isolation, ao mesmo tempo que consegue ser profundo por sua imensidade de ritmos, garante ao catálogo de Kali Uchis uma lista grande de hits.'
      },
      {
        id: 3,
        title: 'Vinil-Lana Del Rey-Lust For Life',
        price: 170.60,
        category: 'Artistas femininas',
        image: 'fotossite/ldrlustforlife.webp',
        rating: 4.7,
        description: 'Cheia de recados, Lana vai e vem de suas batalhas pessoais mas nunca entrega o óbvio. Seu romantismo apimentado não é superficial, e muito menos sua imagem de donzela como ela se mostra na capa. E se “the lust for life keeps us alive”, a hora é agora. Lana Del Rey não precisa provar mais nada para ninguém.'
      },
      {
        id: 4,
        title: 'Vinil-Pheobe Bridgers-Punisher',
        price: 175.80,
        category: 'Artistas femininas',
        image: 'fotossite/pbpunisher.jpg',
        rating: 5.0,
        description: 'Phoebe Bridgers, em seu segundo álbum de estúdio, trata sobre decepções e descobertas comuns mas impõe tanto sentimentalismo a eles que parece estarmos experienciando aquilo pela primeira vez. É como se inocência e sabedoria estranhamente achassem um ponto médio e inexplicavelmente coexistissem sob a mesma situação. '
      },
      {
        id: 5,
        title: 'Vinil-The 1975-The1975',
        price: 155.66,
        category: 'Artistas masculinos',
        image: 'fotossite/the19751.jpg',
        rating: 4.5,
        description: 'The 1975 é o primeiro álbum de estúdio da banda de Indie rock inglesa The 1975. O álbum e a banda são normalmente rotulados como rock, mas a grande variedade de gêneros no álbum o levou a ser descrito como electropop, emo, indie pop, pop, pop punk e pop rock.'
      },
      {
        id: 6,
        title: 'Vinil-The Weeknd-Dawn FM',
        price: 170.20,
        category: 'Lançamentos',
        image: 'fotossite/twdawnfm.jpg',
        rating: 4.9,
        description: 'Às vezes, é só colocando tudo em letras garrafais que conseguimos encontrar as verdades mais profundas e escondidas de nós mesmos. Às vezes, a serenidade está no abraço do barulho, e não no silêncio. O Dawn FM triunfa como extravagância pop e como exploração sentimental íntima porque entende que essas duas coisas não são antagônicas.'
      },
      {
        id: 7,
        title: 'Vinil-Taylor Swift-Midnights',
        price: 180.10,
        category: 'Lançamentos',
        image: 'fotossite/tsmidnights.jpg',
        rating: 4.7,
        description: 'Midnights é imersivo, como se espera de madrugadas ruminativas, tamanha sua coesão, da premissa à execução. Ainda que sua produção acene para uma Taylor Swift do passado, o álbum traz uma compositora madura que, até quando resgata artifícios anteriores.'
      },
      {
        id: 8,
        title: 'Vinil-Tyler The Creator-IGOR',
        price: 150.66,
        category: 'Artistas masculinos',
        image: 'fotossite/ticurrents.jpg',
        rating: 4.5,
        description: 'Naturalmente estranho, como tudo aquilo que o rapper vem produzindo desde o início da presente década, IGOR mostra a capacidade do artista californiano em se reinventar dentro de estúdio, mesmo partindo de uma estrutura temática há muito desgastada e consumida pelos excessos.'
      },
      {
        id: 9,
        title: 'Vinil-Tame Impala-Currents',
        price: 145.66,
        category: 'Artistas masculinos',
        image: 'fotossite/ticurrents.jpg',
        rating: 5.0,
        description: 'Currents é definitivamente um Tame Impala diferente e que vai dividir opiniões. Mas o fato é que a iniciativa de Kevin Parker foi corajosa nessa curva, e a homenagem a esse lado anos 80 e synthpop foi muito bem trabalhada, ainda que não tenha atingido seu potencial máximo. Não é o álbum definitivo que se esperava da banda, mas também não fica atrás na ótima discografia.'
      },
      {
        id: 10,
        title: 'Vinil-Rihanna-ANTI',
        price: 160.30,
        category: 'Artistas femininas',
        image: 'fotossite/ranti.jpg',
        rating: 4.9,
        description: 'ANTI é um trabalho confuso. Essa é a palavra que mais o define. Parece uma metamorfose incompleta de Rihanna. Mas se levarmos em conta que aqui Rihanna mostra alguns de seus lados mais interessantes, o disco ainda sai no saldo positivo. Mostrando um bom lado alternativo, além de se afastar dos terríveis auto-tunes, se dedicando a seus vocais mais limpos, o resultado é bastante satisfatório.'
      },
      {
        id: 11,
        title: 'Vinil-Lord-Melodrama',
        price: 175.66,
        category: 'Artistas femininas',
        image: 'fotossite/lmelodrama.jpg',
        rating: 4.7,
        description: 'É algo emblemático de um disco pop moderno que valoriza a intimidade clássica, e se arrasta até bem depois de as luzes terem sido acesas.'
      },
      {
        id: 12,
        title: 'Vinil-Billie Eilish-Happier Than Ever',
        price: 159.86,
        category: 'Lançamentos',
        image: 'fotossite/behappier.jpg',
        rating: 4.6,
        description: ' Das fantasias idealizadas e criadas através da arte até a mais bruta e crua realidade, o segundo álbum de Billie Eilish é corajoso o suficiente para enfrentar e colocar abaixo todas as cadeias em que o prendiam: evolui liricamente, expande os horizontes de sua música e refina os elementos de produção apresentados no primeiro álbum. '
      },
      {
        id: 13,
        title: 'Vinil-Beabadoobee-Beatopia',
        price: 125.40,
        category: 'Lançamentos',
        image: 'fotossite/beatopia.jpg',
        rating: 4.5,
        description: 'São canções em que a artista mergulha na construção de versos existenciais, desilusões amorosas e tormentos sentimentais compartilhados por qualquer jovem adulto. Dessa forma, beabadoobee garante ao público uma obra que preserva tudo aquilo que tem sido explorado desde os primeiros registros autorais, porém, pontuada por momentos de maior transformação.'
      },
      {
        id: 14,
        title: 'Vinil-Silk Sonik-An Evening Whith Silk Sonic',
        price: 165.76,
        category: 'Lançamentos',
        image: 'fotossite/silksonic.jpg',
        rating: 4.8,
        description: 'O álbum An Evening With Silk Sonic parece e soa como uma piada interna. Idealizado por Bruno Mars e Anderson .Paak, o disco é uma explosão de nostalgia, vintage e afeto pelo soul, funk e R&B dos anos 70 em um contexto pop e mainstream contemporâneo.'
      },
      {
        id: 15,
        title: 'Vinil-Kendrick Lamar-good kid, m.A.A.d city',
        price: 170.66,
        category: 'Artistas masculinos',
        image: 'fotossite/kendrick.jpg',
        rating: 4.7,
        description: '"good kid, m.A.A.d city" é mais do que um álbum, ou um filme sonoro, é um estudo sobre a vida em Compton, uma cidade no sul da Califórnia conhecida por sua violência. Com suas narrativas ultra realistas ele contextualiza diversas histórias, e o que impressiona é que o que para nós é brutal, para ele é mais um dia comum. "good kid, m.A.A.d city" é um dos melhores álbuns do nosso tempo. '
      },
      {
        id: 16,
        title: 'Vinil-Taylor Swift/Midnights',
        price: 190.00,
        category: 'Melhores avaliados',
        image: 'fotossite/tsmidnights.jpg',
        rating: 5.0,
        description: 'Midnights é imersivo, como se espera de madrugadas ruminativas, tamanha sua coesão, da premissa à execução. Ainda que sua produção acene para uma Taylor Swift do passado, o álbum traz uma compositora madura que, até quando resgata artifícios anteriores.'
      },
      {
        id: 17,
        title: 'Vinil-The Weeknd/Starboy',
        price: 160.66,
        category: 'Melhores avaliados',
        image: 'fotossite/twstarboy.jpg',
        rating: 5.0,
        description: 'Starboy, mesmo não sendo tão longo, pouco mais de uma hora, dá a impressão de ser uma peça que precisa ser desvendada, mas de forma agradável. É um projeto criado para quem está em busca de um pop que não é simples, mas que une uma gama intrincada de referências a possibilidade de fácil assimilação. '
      },
      {
        id: 18,
        title: 'Vinil-Harry Stiles/Fine Line',
        price:  165.65,
        category: 'Melhores avaliados',
        image: 'fotossite/hsfineline.jpg',
        rating: 5.0,
        description: 'Harry Styles disse que seu álbum Fine Line é sobre fazer sexo e sobre se sentir triste. É a melhor definição para a juventude inconsequente e exagerada, não é mesmo? Rompimento de namoros levam a crises existenciais e um dos maiores propósitos de viver está no amor debaixo de lençóis. Sei que nem todos são assim, mas a maioria é, pelo menos às vezes.'
      },
      {
        id: 19,
        title: 'Vinil-Beyonce/Renaissence',
        price: 175.75,
        category: 'Melhores avaliados',
        image: 'fotossite/brenaissance.jpg',
        rating: 5.0,
        description: 'Renaissance nos apresenta uma Beyoncé sem medo de inovar e de se arriscar, trazendo seu álbum de estúdio mais impressionante sonoramente e artisticamente. É uma obra tecnicamente ousada para a cantora, integrando house, hip-hop, soul, funk e, acima de tudo, disco e dance music para experimentar com o R&B e o pop que a tornaram icônica, mas com uma coesão ímpar e com um cuidado harmônico absurdo. Renaissance é sexy e super divertido, feito para celebrar nossos desejos e essências, feito para dançar e ficar em êxtase.'
      },
  ];

  const idProduto = parseInt(obterValorParametro('id'));
  console.log('ID do Produto:', idProduto);

  const produto = produtos.find(produto => produto.id === idProduto);

  exibirInformacoesProduto(produto);

  function exibirInformacoesProduto(produto) {
    if (produto) {
      const nomeElemento = document.getElementById('nome_prod');
      const precoElemento = document.getElementById('preco_prod');
      const descricaoElemento = document.getElementById('desc_prod');
      const imagemElemento = document.getElementById('img_prod');

      nomeElemento.textContent = produto.title;
      precoElemento.textContent = `$${produto.price}`;
      descricaoElemento.textContent = produto.description;
      imagemElemento.src = produto.image;
    }
  }