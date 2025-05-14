import React from 'react'
import HeaderComponent from '../../components/website/HeaderComponent'

const EventPage = () => {
  return (
    <div>
        <div className="page-title" data-aos="fade">
                <HeaderComponent title="Evenements" />
                <nav className="breadcrumbs">
                    <div className="container">
                        <ol>
                            <li><a href="/">Accueil</a></li>
                        <li className="current">Evenements</li>
                        </ol>
                    </div>
                </nav>
            </div>
    </div>
  )
}

export default EventPage
