const categorySelect = document.getElementById('category-select');
const produtosContainer = document.getElementById('produtos-display');

const meusProdutos = [
  {
    title: 'Vinil-Hozier-Wasteland Baby!',
    price:  165.00,
    category: 'Artistas masculinos',
    image: 'fotossite/hozierwasteland.jpg',
    rating: '4.5'
  },
  {
    title: 'Vinil-Rina Sawayama-SAWAYAMA',
    price: 160.99,
    category: 'Artistas femininas',
    image: 'fotossite/rinasawayama.jpg',
    rating: 4.0 
  },
  {
    title: 'Vinil-Kali Uchis-Isolation',
    price: 155.66,
    category: 'Artistas femininas',
    image: 'fotossite/kuisolation.jpg',
    rating: 4.3
  },
  {
    title: 'Vinil-Lana Del Rey-Lust For Life',
    price: 170.60,
    category: 'Artistas femininas',
    image: 'fotossite/ldrlustforlife.webp',
    rating: 4.7
  },
  {
    title: 'Vinil-Pheobe Bridgers-Punisher',
    price: 175.80,
    category: 'Artistas femininas',
    image: 'fotossite/pbpunisher.jpg',
    rating: 5.0
  },
  {
    title: 'Vinil-The 1975-The1975',
    price: 155.66,
    category: 'Artistas masculinos',
    image: 'fotossite/the19751.jpg',
    rating: 4.5
  },
  {
    title: 'Vinil-The Weeknd-Dawn FM',
    price: 170.20,
    category: 'Lançamentos',
    image: 'fotossite/twdawnfm.jpg',
    rating: 4.9
  },
  {
    title: 'Vinil-Taylor Swift-Midnights',
    price: 180.10,
    category: 'Lançamentos',
    image: 'fotossite/tsmidnights.jpg',
    rating: 4.7
  },
  {
    title: 'Vinil-Tyler The Creator-IGOR',
    price: 150.66,
    category: 'Artistas masculinos',
    image: 'fotossite/igortyler.jpg',
    rating: 4.5
  },
  {
    title: 'Vinil-Tame Impala-Currents',
    price: 145.66,
    category: 'Artistas masculinos',
    image: 'fotossite/ticurrents.jpg',
    rating: 5.0
  },
  {
    title: 'Vinil-Rihanna-ANTI',
    price: 160.30,
    category: 'Artistas femininas',
    image: 'fotossite/ranti.jpg',
    rating: 4.9
  },
  {
    title: 'Vinil-Lord-Melodrama',
    price: 175.66,
    category: 'Artistas femininas',
    image: 'fotossite/lmelodrama.jpg',
    rating: 4.7
  },
  {
    title: 'Vinil-Billie Eilish-Happier Than Ever',
    price: 159.86,
    category: 'Lançamentos',
    image: 'fotossite/behappier.jpg',
    rating: 4.6
  },
  {
    title: 'Vinil-Beabadoobee-Beatopia',
    price: 125.40,
    category: 'Lançamentos',
    image: 'fotossite/beatopia.jpg',
    rating: 4.5
  },
  {
    title: 'Vinil-Silk Sonik-An Evening Whith Silk Sonic',
    price: 165.76,
    category: 'Lançamentos',
    image: 'fotossite/silksonic.jpg',
    rating: 4.8
  },
  {
    title: 'Vinil-Kendrick Lamar-good kid, m.A.A.d city',
    price: 170.66,
    category: 'Artistas masculinos',
    image: 'fotossite/kendrick.jpg',
    rating: 4.7
  },
  {
    title: 'Vinil-Taylor Swift/Midnights',
    price: 190.00,
    category: 'Melhores avaliados',
    image: 'fotossite/tsmidnights.jpg',
    rating: 5.0
  },
  {
    title: 'Vinil-The Weeknd/Starboy',
    price: 160.66,
    category: 'Melhores avaliados',
    image: 'fotossite/twstarboy.jpg',
    rating: 5.0
  },
  {
    title: 'Vinil-Harry Stiles/Fine Line',
    price: 165.65,
    category: 'Melhores avaliados',
    image: 'fotossite/hsfineline.jpg',
    rating: 5.0
  },
  {
    title: 'Vinil-Beyonce/Renaissence',
    price: 175.75,
    category: 'Melhores avaliados',
    image: 'fotossite/brenaissance.jpg',
    rating: 5.0
  },

  
];

const produtos = meusProdutos;

function exibirProdutos(produtos) {
  produtosContainer.innerHTML = '';

  for (let i = produtos.length - 1; i >= 0; i--) {
    const produto = produtos[i];
    const titulo = produto.title;
    const preco = produto.price;
    const nome = produto.category;
    const imagem = produto.image;
    const avaliacao = produto.rating ? produto.rating : 'N/A'; // Se a avaliação não estiver disponível, exibe 'N/A'

    const colElement = document.createElement('div');
    colElement.classList.add('col-6', 'col-md-4', 'col-lg-3', 'mb-4');
    colElement.style.padding = '20px';

    const cardElement = document.createElement('div');
    cardElement.classList.add('card', 'h-100');
    cardElement.style.borderRadius = '20px';
    cardElement.style.border = '4px solid black';

    const imagemElement = document.createElement('img');
    imagemElement.src = imagem;
    imagemElement.classList.add('card-img-top', 'img-fluid', 'prodCont');
    imagemElement.style.objectFit = 'contain';
    imagemElement.style.height = '200px';
    imagemElement.style.margin = 'auto';
    cardElement.appendChild(imagemElement);

    const infoElement = document.createElement('div');
    infoElement.classList.add('card-body', 'text-center');
    infoElement.innerHTML = `<h5 class="card-title">Nome do produto: ${titulo}</h5>
                             <p class="card-text">Preço do produto: ${preco}</p>
                             <p class="card-text">Avaliação do produto: ${avaliacao} / 5.0</p>
                             <p class="card-text">Categoria do produto: ${nome}</p>`;
    cardElement.appendChild(infoElement);

    const buttonElement = document.createElement('button');
    buttonElement.classList.add('btn');
    buttonElement.textContent = 'Ver Detalhes';
    buttonElement.setAttribute('data-id', i); // Alterado para usar o índice como ID
    buttonElement.addEventListener('click', () => {
      window.location.href = 'detalhes.html' + '?id=' + i; // Alterado para usar o índice como parâmetro
    });

    cardElement.appendChild(buttonElement);

    colElement.appendChild(cardElement);
    produtosContainer.appendChild(colElement);
  }
}

function filtrarProdutos(categoria) {
  if (categoria) {
    const produtosFiltrados = produtos.filter(produto => produto.category.toLowerCase() === categoria.toLowerCase());
    exibirProdutos(produtosFiltrados);
  } else {
    exibirProdutos(produtos);
  }
}

categorySelect.addEventListener('change', () => {
  const categoriaSelecionada = categorySelect.value;
  filtrarProdutos(categoriaSelecionada);
});

filtrarProdutos('');
