import { expect, Page } from '@playwright/test';

export class CreateQuizAIPOM {
  page: Page;
  createNewQuizButtonOnDashboard: any;
  chooseQuziAIButton: any;
  quizAINameField: any;
  assignUser: any;
  acceptAINextButton: any;
  createQuizButton: any;
  manageQuizzesHeader: any;
  createdAIQuiz: any;

  constructor(page: Page) {
    this.page = page
    this.createNewQuizButtonOnDashboard = page.getByRole('button', { name: 'Create quiz' })
    this.chooseQuziAIButton = page.getByRole('button', { name: 'Configure' }).first()
    this.quizAINameField = page.getByRole('textbox', { name: 'Quiz name Quiz name' })
    this.acceptAINextButton = page.getByRole('button', { name: 'Next' })
    this.createQuizButton = page.getByRole('button', { name: 'Create quiz' })
    this.manageQuizzesHeader = page.getByText('Manage your quizzes')
    this.createdAIQuiz = page.locator('.SidebarWithItems_list__xm3B_ > li > a').first()
  }

  async createQuizAI(quizAIName) {
    await this.createNewQuizButtonOnDashboard.click()
    await this.chooseQuziAIButton.click()
    await this.quizAINameField.fill(quizAIName)
    await this.acceptAINextButton.click()
    await this.createQuizButton.click()
  }

  async expectQuizAICreated() {
    await expect(this.manageQuizzesHeader).toBeVisible();
    await expect(this.createdAIQuiz).toBeVisible()
  }
}