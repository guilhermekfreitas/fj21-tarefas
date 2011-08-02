package com.br.caelum.tarefas.interceptor;

import com.br.caelum.tarefas.modelo.Usuario;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class AutorizadorInterceptor implements Interceptor{

	@Override
	public void destroy() {
	}

	@Override
	public void init() {
	}

	// interceptar minha action, e verificar se foi realizado o login
	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		
		Usuario usuario = (Usuario) actionInvocation.getInvocationContext().getSession().get("usuarioLogado");
		if (usuario != null){
			return actionInvocation.invoke();
		}
				
		return "naoLogado";
	}

}
