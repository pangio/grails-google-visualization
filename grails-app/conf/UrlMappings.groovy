class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(controller: 'employee', action: 'index')
        "/index"(controller: 'employee', action: 'index')
        "/charts"(controller: 'employee', action: 'charts')
        "500"(view:'/error')
        "404"(view:'/error')
	}
}
