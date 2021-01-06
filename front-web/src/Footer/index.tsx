import './styles.css';
import {ReactComponent as YouTubeIcon} from './youtube.svg';
import {ReactComponent as LinkedinIcon} from './linkedin.svg';
import {ReactComponent as InstagramIcon} from './instagram.svg';

function Footer() {
    return (
        <footer className="main-footer">
            App desenvolvido durante a 2ª edição do evento Semana DevSuperior
            <div className="footer-icons">
                <a href="https://www.youtube.com/channel/UCmQ39rZeUW3dxMiSjm6YX7Q" target="_new"><YouTubeIcon/></a>
                <a href="https://www.linkedin.com/in/andrew-monteiro-b341391b5/" target="_new"><LinkedinIcon/></a>
                <a href="https://www.instagram.com/andrewbunro/" target="_new"><InstagramIcon/></a>
            </div>
        </footer>
    )
}

export default Footer;