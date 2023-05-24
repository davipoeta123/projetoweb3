// Selecionando os elementos do DOM
const form = document.querySelector('form');
const nomeInput = document.getElementById('nome');
const emailInput = document.getElementById('email');
const telefoneInput = document.getElementById('telefone');
const generoInputs = document.getElementsByName('genero');
const dataNascimentoInput = document.getElementById('data_nascimento');
const cidadeInput = document.getElementById('cidade');
const estadoInput = document.getElementById('estado');
const enderecoInput = document.getElementById('endereço');

// Função para validar o formulário
function validarFormulario(event) {
  // Previne o envio do formulário caso haja erros
  event.preventDefault();

  // Valida o nome
  if (nomeInput.value.trim() === '') {
    alert('Por favor, preencha o campo nome');
    nomeInput.focus();
    return false;
  }

  // Valida o e-mail
  if (emailInput.value.trim() === '') {
    alert('Por favor, preencha o campo e-mail');
    emailInput.focus();
    return false;
  }

  // Valida o telefone
  if (telefoneInput.value.trim() === '') {
    alert('Por favor, preencha o campo telefone');
    telefoneInput.focus();
    return false;
  }

  // Valida o gênero
  let generoSelecionado = false;
  for (let i = 0; i < generoInputs.length; i++) {
    if (generoInputs[i].checked) {
      generoSelecionado = true;
      break;
    }
  }
  if (!generoSelecionado) {
    alert('Por favor, selecione o gênero');
    return false;
  }

  // Valida a data de nascimento
  if (dataNascimentoInput.value.trim() === '') {
    alert('Por favor, preencha o campo data de nascimento');
    dataNascimentoInput.focus();
    return false;
  }

  // Valida a cidade
  if (cidadeInput.value.trim() === '') {
    alert('Por favor, preencha o campo cidade');
    cidadeInput.focus();
    return false;
  }

  // Valida o estado
  if (estadoInput.value.trim() === '') {
    alert('Por favor, preencha o campo estado');
    estadoInput.focus();
    return false;
  }

  // Valida o endereço
  if (enderecoInput.value.trim() === '') {
    alert('Por favor, preencha o campo endereço');
    enderecoInput.focus();
    return false;
  }

  // Se chegou até aqui, o formulário é válido e pode ser enviado
  alert('Formulário enviado com sucesso!');
  return true;
}

// Adicionando o listener para a submissão do formulário
form.addEventListener('submit', validarFormulario);