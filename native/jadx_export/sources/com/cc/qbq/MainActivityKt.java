package com.cc.qbq;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MainActivity.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u001a \u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004H\u0007¢\u0006\u0002\u0010\u0005\u001a\u0017\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\t\u001a\r\u0010\n\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u000b¨\u0006\f²\u0006\n\u0010\r\u001a\u00020\u000eX\u008a\u008e\u0002²\u0006\f\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u008a\u008e\u0002"}, d2 = {"QbqTheme", "", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "PasswordCheckScreen", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "PasswordCheckPreview", "(Landroidx/compose/runtime/Composer;I)V", "app", HintConstants.AUTOFILL_HINT_PASSWORD, "", "resultText"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MainActivityKt {
    static final Unit PasswordCheckPreview$lambda$14(int i, Composer composer, int i2) {
        PasswordCheckPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit PasswordCheckScreen$lambda$13(Modifier modifier, int i, int i2, Composer composer, int i3) {
        PasswordCheckScreen(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit QbqTheme$lambda$0(Function2 function2, int i, Composer composer, int i2) {
        QbqTheme(function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void QbqTheme(Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, final int $changed) {
        final Function2 content2;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer2 = $composer.startRestartGroup(-465160847);
        ComposerKt.sourceInformation($composer2, "C(QbqTheme)46@1667L32:MainActivity.kt#cfffgf");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(content) ? 4 : 2;
        }
        if (($dirty & 3) == 2 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            content2 = content;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-465160847, $dirty, -1, "com.cc.qbq.QbqTheme (MainActivity.kt:45)");
            }
            content2 = content;
            MaterialThemeKt.MaterialTheme(null, null, null, content2, $composer2, ($dirty << 9) & 7168, 7);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.cc.qbq.MainActivityKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MainActivityKt.QbqTheme$lambda$0(content2, $changed, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void PasswordCheckScreen(Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Object objMutableStateOf$default;
        Object objMutableStateOf$default2;
        Composer $composer2;
        Function0 function0;
        Object obj;
        Composer $composer3 = $composer.startRestartGroup(-193801321);
        ComposerKt.sourceInformation($composer3, "C(PasswordCheckScreen)51@1792L31,52@1846L42,54@1894L926:MainActivity.kt#cfffgf");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if (($dirty & 3) == 2 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        } else {
            Modifier.Companion modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-193801321, $dirty, -1, "com.cc.qbq.PasswordCheckScreen (MainActivity.kt:50)");
            }
            ComposerKt.sourceInformationMarkerStart($composer3, -1559472874, "CC(remember):MainActivity.kt#9igjgp");
            Object objRememberedValue = $composer3.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objMutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                $composer3.updateRememberedValue(objMutableStateOf$default);
            } else {
                objMutableStateOf$default = objRememberedValue;
            }
            final MutableState password$delegate = (MutableState) objMutableStateOf$default;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, -1559471135, "CC(remember):MainActivity.kt#9igjgp");
            Object objRememberedValue2 = $composer3.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objMutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                $composer3.updateRememberedValue(objMutableStateOf$default2);
            } else {
                objMutableStateOf$default2 = objRememberedValue2;
            }
            final MutableState resultText$delegate = (MutableState) objMutableStateOf$default2;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifierM681padding3ABfNKs = PaddingKt.m681padding3ABfNKs(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null), Dp.m6693constructorimpl(24));
            Arrangement.Vertical center = Arrangement.INSTANCE.getCenter();
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, centerHorizontally, $composer3, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            $composer2 = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap currentCompositionLocalMap = $composer3.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier($composer3, modifierM681padding3ABfNKs);
            Function0 constructor = ComposeUiNode.INSTANCE.getConstructor();
            int i3 = ((((432 << 3) & 112) << 6) & 896) | 6;
            Modifier modifier4 = modifier3;
            ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                function0 = constructor;
                $composer3.createNode(function0);
            } else {
                function0 = constructor;
                $composer3.useNode();
            }
            Composer composerM3678constructorimpl = Updater.m3678constructorimpl($composer3);
            Updater.m3685setimpl(composerM3678constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3685setimpl(composerM3678constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3678constructorimpl.getInserting() || !Intrinsics.areEqual(composerM3678constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM3678constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM3678constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3685setimpl(composerM3678constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            int i4 = (i3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -384862393, "C87@4365L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            int i5 = ((432 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 255835032, "C63@2189L17,61@2112L220,68@2341L41,70@2421L173,69@2391L297:MainActivity.kt#cfffgf");
            String strPasswordCheckScreen$lambda$2 = PasswordCheckScreen$lambda$2(password$delegate);
            ComposerKt.sourceInformationMarkerStart($composer3, 146801854, "CC(remember):MainActivity.kt#9igjgp");
            Object objRememberedValue3 = $composer3.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: com.cc.qbq.MainActivityKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return MainActivityKt.PasswordCheckScreen$lambda$12$lambda$8$lambda$7(password$delegate, (String) obj2);
                    }
                };
                $composer3.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            OutlinedTextFieldKt.OutlinedTextField(strPasswordCheckScreen$lambda$2, (Function1<? super String, Unit>) objRememberedValue3, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$MainActivityKt.INSTANCE.getLambda$815840807$app(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, true, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, $composer3, 1573296, 12582912, 0, 8257464);
            SpacerKt.Spacer(SizeKt.m712height3ABfNKs(Modifier.INSTANCE, Dp.m6693constructorimpl(16)), $composer3, 6);
            ComposerKt.sourceInformationMarkerStart($composer3, 146809434, "CC(remember):MainActivity.kt#9igjgp");
            Object objRememberedValue4 = $composer3.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.cc.qbq.MainActivityKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return MainActivityKt.PasswordCheckScreen$lambda$12$lambda$10$lambda$9(password$delegate, resultText$delegate);
                    }
                };
                $composer3.updateRememberedValue(obj);
            } else {
                obj = objRememberedValue4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ButtonKt.Button((Function0) obj, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), false, null, null, null, null, null, null, ComposableSingletons$MainActivityKt.INSTANCE.m6993getLambda$515286787$app(), $composer3, 805306422, 508);
            String strPasswordCheckScreen$lambda$5 = PasswordCheckScreen$lambda$5(resultText$delegate);
            if (strPasswordCheckScreen$lambda$5 == null) {
                $composer3.startReplaceGroup(256408747);
                $composer3.endReplaceGroup();
            } else {
                $composer3.startReplaceGroup(256408748);
                ComposerKt.sourceInformation($composer3, "*82@2734L41,83@2788L16");
                SpacerKt.Spacer(SizeKt.m712height3ABfNKs(Modifier.INSTANCE, Dp.m6693constructorimpl(16)), $composer3, 6);
                TextKt.m2711Text4IGK_g(strPasswordCheckScreen$lambda$5, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, 0, 0, 131070);
                $composer3.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier4;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.cc.qbq.MainActivityKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return MainActivityKt.PasswordCheckScreen$lambda$13(modifier2, $changed, i, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    private static final String PasswordCheckScreen$lambda$2(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String PasswordCheckScreen$lambda$5(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    static final Unit PasswordCheckScreen$lambda$12$lambda$8$lambda$7(MutableState $password$delegate, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $password$delegate.setValue(it);
        return Unit.INSTANCE;
    }

    static final Unit PasswordCheckScreen$lambda$12$lambda$10$lambda$9(MutableState $password$delegate, MutableState $resultText$delegate) {
        String str;
        if (NativeAuth.INSTANCE.aaa(PasswordCheckScreen$lambda$2($password$delegate))) {
            str = "校验通过";
        } else {
            str = "校验失败";
        }
        $resultText$delegate.setValue(str);
        return Unit.INSTANCE;
    }

    public static final void PasswordCheckPreview(Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-869333716);
        ComposerKt.sourceInformation($composer2, "C(PasswordCheckPreview)91@2901L46:MainActivity.kt#cfffgf");
        if ($changed == 0 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-869333716, $changed, -1, "com.cc.qbq.PasswordCheckPreview (MainActivity.kt:90)");
            }
            QbqTheme(ComposableSingletons$MainActivityKt.INSTANCE.m6991getLambda$23243594$app(), $composer2, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.cc.qbq.MainActivityKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MainActivityKt.PasswordCheckPreview$lambda$14($changed, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
