import { Component, OnInit, Inject, PLATFORM_ID } from '@angular/core';
import { CommonModule, isPlatformBrowser } from '@angular/common';
import { FormsModule } from '@angular/forms';
import {FormBuilder, FormGroup, Validators, ReactiveFormsModule} from '@angular/forms';
import {Router} from '@angular/router';
import {AuthService} from '../../core/auth.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, FormsModule, ReactiveFormsModule],
  templateUrl: './login.html',
  styleUrls: ['./login.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
    errorMessage = '';
    loading = false;
    isBrowser: boolean;

    constructor(
      private fb: FormBuilder,
      private authService: AuthService,
      private router: Router,
      @Inject(PLATFORM_ID) private platformId: Object
    ) {
      this.isBrowser = isPlatformBrowser(this.platformId);
      this.loginForm = this.fb.group({
        email: ['', [Validators.required, Validators.email]],
        password: ['', Validators.required]
      });
    }

    ngOnInit(): void {
        if (this.isBrowser) {
          const isLoggedIn = localStorage.getItem('isLoggedIn');
          if (isLoggedIn) {
            this.router.navigate(['/dashboard']);
          }
        }
      }

    onSubmit() {
      if (this.loginForm.invalid) {
        return;
      }

      this.loading = true;
      const { email, password } = this.loginForm.value;

      this.authService.login(email, password).subscribe({
        next: (res) => {
          this.loading = false;
          console.log('Login success:', res);
          if (this.isBrowser){
            localStorage.setItem('isLoggedIn', 'true');
          }
          this.router.navigate(['/dashboard']);
        },
        error: (err) => {
          this.loading = false;
          this.errorMessage = 'Invalid credentials';
          console.error('Login error', err);
        }
      });
    }
}
