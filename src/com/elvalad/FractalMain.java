package com.elvalad;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FractalMain extends JFrame implements ActionListener {
    private JMenuBar menuBar;
    private JMenu fractalMenu;
    private JMenuItem blankItem;
    private JMenuItem cantorItem;
    private JMenuItem kochItem;
    private ShapeStyle style;
    private FractalPanel fractalPanel = new FractalPanel();

    /**
     * FractalMain类的构造函数
     */
    public FractalMain() {
        /* JFrame继承自awt Frame类的方法，设置窗体标题 */
        this.setTitle("Fractal");
        /* 设置JFrame的初始大小 */
        this.setSize(1000, 1000);
        /* 设置用户在此窗体上发起 "close" 时默认执行的操作 */
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        /* 设置窗口相对于指定组件的位置，当为null时在正中央 */
        this.setLocationRelativeTo(null);
        /* 建立menu */
        this.buildMenuBar();
        /* 设置此窗体的菜单栏 */
        this.setJMenuBar(this.menuBar);
        /* 添加fractalPanel到JFrame中央 */
        this.add(this.fractalPanel, "Center");
        /* 继承自Window类，根据参数显示或隐藏组件 */
        this.setVisible(true);
    }

    /**
     * 创建MenuBar
     * MenuBar: menuBar
     * Menu: fractalMenu
     *      MenuItem: blankItem
     *      MenuItem: cantorItem
     *      MenuItem: kochItem
     */
    private void buildMenuBar() {
        this.menuBar = new JMenuBar();
        this.fractalMenu = new JMenu("Fractal");
        this.blankItem = new JMenuItem("Blank");
        this.blankItem.addActionListener(this);
        this.cantorItem = new JMenuItem("Cantor");
        this.cantorItem.addActionListener(this);
        this.kochItem = new JMenuItem("Koch");
        this.kochItem.addActionListener(this);
        this.menuBar.add(this.fractalMenu);
        this.fractalMenu.add(this.blankItem);
        this.fractalMenu.add(this.cantorItem);
        this.fractalMenu.add(this.kochItem);
    }

    /**
     * 通过设置PaintStyle来绘制不同的图案
     * 清空Panel上的图案
     */
    private void drawBlankOnPanel() {
        this.style = ShapeStyle.BLANK;
        this.fractalPanel.setPaintStype(this.style);
        this.repaint();
    }

    /**
     * 通过设置PaintStyle来绘制不同的图案
     * 绘制Cantor三分集
     */
    private void drawCantorOnPanel() {
        this.style = ShapeStyle.CANTOR;
        this.fractalPanel.setPaintStype(this.style);
        this.repaint();
    }

    /**
     * 绘制Koch曲线
     */
    private void drawKochOnPanel() {
        this.style = ShapeStyle.KOCH;
        this.fractalPanel.setPaintStype(this.style);
        this.repaint();
    }

    /**
     *
     * @param e awt事件接口，用于判断此时是哪种事件来选择执行不同的方法
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.blankItem) {
            this.drawBlankOnPanel();
        } else if (e.getSource() == this.cantorItem) {
            this.drawCantorOnPanel();
        } else if (e.getSource() == this.kochItem) {
            this.drawKochOnPanel();
        }
    }

    public static void main(String[] args) {
        new FractalMain();
    }
}
