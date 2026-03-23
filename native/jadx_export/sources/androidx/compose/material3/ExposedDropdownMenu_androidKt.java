package androidx.compose.material3;

import android.content.res.Configuration;
import android.view.View;
import androidx.activity.compose.BackHandlerKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* compiled from: ExposedDropdownMenu.android.kt */
@Metadata(d1 = {"\u0000r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aQ\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u001c\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\r¢\u0006\u0002\b\u000eH\u0007¢\u0006\u0002\u0010\u000f\u001a+\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0016H\u0003¢\u0006\u0002\u0010\u0017\u001a\"\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001d\u001a\u00020\u0019H\u0002\u001aV\u0010\u001e\u001a\u00020\n*\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00162\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"2\b\u0010%\u001a\u0004\u0018\u00010&H\u0002ø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001a\u000e\u0010)\u001a\u00020\u001b*\u0004\u0018\u00010*H\u0002\u001a\f\u0010+\u001a\u00020\u001b*\u00020\u0012H\u0002\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006,²\u0006\f\u0010-\u001a\u0004\u0018\u00010*X\u008a\u008e\u0002²\u0006\n\u0010.\u001a\u00020\u0019X\u008a\u008e\u0002²\u0006\n\u0010/\u001a\u00020\u0019X\u008a\u008e\u0002"}, d2 = {"ExposedDropdownMenuItemHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "ExposedDropdownMenuBox", "", "expanded", "", "onExpandedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Landroidx/compose/material3/ExposedDropdownMenuBoxScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "SoftKeyboardListener", "view", "Landroid/view/View;", "density", "Landroidx/compose/ui/unit/Density;", "onKeyboardVisibilityChange", "Lkotlin/Function0;", "(Landroid/view/View;Landroidx/compose/ui/unit/Density;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "calculateMaxHeight", "", "windowBounds", "Landroidx/compose/ui/geometry/Rect;", "anchorBounds", "verticalMargin", "expandable", "anchorType", "Landroidx/compose/material3/MenuAnchorType;", "expandedDescription", "", "collapsedDescription", "toggleDescription", "keyboardController", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "expandable-Gq7TBQ4", "(Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function0;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/platform/SoftwareKeyboardController;)Landroidx/compose/ui/Modifier;", "getAnchorBounds", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getWindowBounds", "material3_release", "anchorCoordinates", "anchorWidth", "menuMaxHeight"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ExposedDropdownMenu_androidKt {
    private static final float ExposedDropdownMenuItemHorizontalPadding = Dp.m6693constructorimpl(16);

    public static final void ExposedDropdownMenuBox(final boolean expanded, final Function1<? super Boolean, Unit> function1, Modifier modifier, Function3<? super ExposedDropdownMenuBoxScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Object value$iv;
        Object value$iv2;
        Object value$iv3;
        Object value$iv4;
        int $dirty;
        Modifier modifier3;
        Density density;
        final String collapsedDescription;
        int $dirty2;
        final MutableIntState anchorWidth$delegate;
        final MutableState anchorTypeState;
        final String expandedDescription;
        final String expandedDescription2;
        final View view;
        final SoftwareKeyboardController keyboardController;
        Object value$iv5;
        final FocusRequester focusRequester;
        final int verticalMargin;
        final MutableState anchorCoordinates$delegate;
        final MutableIntState menuMaxHeight$delegate;
        Object value$iv6;
        Function0 factory$iv$iv$iv;
        final Function3<? super ExposedDropdownMenuBoxScope, ? super Composer, ? super Integer, Unit> function32;
        Object value$iv7;
        Object value$iv8;
        final Modifier modifier4;
        Object value$iv9;
        final boolean z = expanded;
        final Function1<? super Boolean, Unit> function12 = function1;
        Composer $composer2 = $composer.startRestartGroup(2067579792);
        ComposerKt.sourceInformation($composer2, "C(ExposedDropdownMenuBox)P(1,3,2)140@6498L7,141@6531L7,142@6570L7,146@6683L53,147@6760L33,148@6819L33,150@6879L29,151@6970L7,152@7008L31,153@7071L32,154@7132L37,155@7196L62,158@7284L2210,200@9543L361,199@9500L442,225@10317L47,225@10306L58,229@10529L27,229@10497L59:ExposedDropdownMenu.android.kt#uh7d8r");
        int $dirty3 = $changed;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty3 |= $composer2.changed(z) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty3 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty3 |= $composer2.changedInstance(function12) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty3 |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        if ((i & 8) != 0) {
            $dirty3 |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty3 |= $composer2.changedInstance(function3) ? 2048 : 1024;
        }
        if (($dirty3 & 1171) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier4 = modifier2;
            function32 = function3;
        } else {
            Modifier.Companion modifier5 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2067579792, $dirty3, -1, "androidx.compose.material3.ExposedDropdownMenuBox (ExposedDropdownMenu.android.kt:139)");
            }
            ProvidableCompositionLocal<Configuration> localConfiguration = AndroidCompositionLocals_androidKt.getLocalConfiguration();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localConfiguration);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Configuration config = (Configuration) objConsume;
            ProvidableCompositionLocal<View> localView = AndroidCompositionLocals_androidKt.getLocalView();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = $composer2.consume(localView);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            View view2 = (View) objConsume2;
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume3 = $composer2.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density density2 = (Density) objConsume3;
            final int verticalMargin2 = density2.mo361roundToPx0680j_4(MenuKt.getMenuVerticalMargin());
            ComposerKt.sourceInformationMarkerStart($composer2, 426259219, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final MutableState anchorCoordinates$delegate2 = (MutableState) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 426261663, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
            Object it$iv2 = $composer2.rememberedValue();
            if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = SnapshotIntStateKt.mutableIntStateOf(0);
                $composer2.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            MutableIntState anchorWidth$delegate2 = (MutableIntState) value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 426263551, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
            Object it$iv3 = $composer2.rememberedValue();
            if (it$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv3 = SnapshotIntStateKt.mutableIntStateOf(0);
                $composer2.updateRememberedValue(value$iv3);
            } else {
                value$iv3 = it$iv3;
            }
            final MutableIntState menuMaxHeight$delegate2 = (MutableIntState) value$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 426265467, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
            Object it$iv4 = $composer2.rememberedValue();
            if (it$iv4 == Composer.INSTANCE.getEmpty()) {
                value$iv4 = new FocusRequester();
                $composer2.updateRememberedValue(value$iv4);
            } else {
                value$iv4 = it$iv4;
            }
            final FocusRequester focusRequester2 = (FocusRequester) value$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ProvidableCompositionLocal<SoftwareKeyboardController> localSoftwareKeyboardController = CompositionLocalsKt.getLocalSoftwareKeyboardController();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume4 = $composer2.consume(localSoftwareKeyboardController);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            SoftwareKeyboardController keyboardController2 = (SoftwareKeyboardController) objConsume4;
            Strings.Companion companion = Strings.INSTANCE;
            String expandedDescription3 = Strings_androidKt.m2992getString2EP1pXo(Strings.m2922constructorimpl(R.string.m3c_dropdown_menu_expanded), $composer2, 0);
            Strings.Companion companion2 = Strings.INSTANCE;
            String collapsedDescription2 = Strings_androidKt.m2992getString2EP1pXo(Strings.m2922constructorimpl(R.string.m3c_dropdown_menu_collapsed), $composer2, 0);
            Strings.Companion companion3 = Strings.INSTANCE;
            String toggleDescription = Strings_androidKt.m2992getString2EP1pXo(Strings.m2922constructorimpl(R.string.m3c_dropdown_menu_toggle), $composer2, 0);
            ComposerKt.sourceInformationMarkerStart($composer2, 426275644, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
            Object value$iv10 = $composer2.rememberedValue();
            if (value$iv10 == Composer.INSTANCE.getEmpty()) {
                $dirty = $dirty3;
                value$iv10 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(MenuAnchorType.m2235boximpl(MenuAnchorType.INSTANCE.m2243getPrimaryNotEditableMg6Rgbw()), null, 2, null);
                $composer2.updateRememberedValue(value$iv10);
            } else {
                $dirty = $dirty3;
            }
            MutableState anchorTypeState2 = (MutableState) value$iv10;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 426280608, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
            boolean invalid$iv = (($dirty & 14) == 4) | (($dirty & 112) == 32) | $composer2.changed(config) | $composer2.changed(view2) | $composer2.changed(density2);
            Object it$iv5 = $composer2.rememberedValue();
            if (invalid$iv || it$iv5 == Composer.INSTANCE.getEmpty()) {
                modifier3 = modifier5;
                density = density2;
                collapsedDescription = collapsedDescription2;
                $dirty2 = $dirty;
                anchorWidth$delegate = anchorWidth$delegate2;
                anchorTypeState = anchorTypeState2;
                expandedDescription = expandedDescription3;
                expandedDescription2 = toggleDescription;
                view = view2;
                keyboardController = keyboardController2;
                value$iv5 = new ExposedDropdownMenuBoxScopeImpl() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1
                    @Override // androidx.compose.material3.ExposedDropdownMenuBoxScope
                    /* renamed from: menuAnchor-fsE2BvY */
                    public Modifier mo2101menuAnchorfsE2BvY(Modifier $this$menuAnchor_u2dfsE2BvY, final String type, boolean enabled) {
                        Modifier.Companion companionM2110expandableGq7TBQ4;
                        Modifier modifierFocusRequester = FocusRequesterModifierKt.focusRequester($this$menuAnchor_u2dfsE2BvY, focusRequester2);
                        if (enabled) {
                            Modifier.Companion companion4 = Modifier.INSTANCE;
                            boolean z2 = expanded;
                            final MutableState<MenuAnchorType> mutableState = anchorTypeState;
                            final Function1<Boolean, Unit> function13 = function1;
                            final boolean z3 = expanded;
                            companionM2110expandableGq7TBQ4 = ExposedDropdownMenu_androidKt.m2110expandableGq7TBQ4(companion4, z2, new Function0<Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1$menuAnchor$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    mutableState.setValue(MenuAnchorType.m2235boximpl(type));
                                    function13.invoke(Boolean.valueOf(!z3));
                                }
                            }, type, expandedDescription, collapsedDescription, expandedDescription2, keyboardController);
                        } else {
                            companionM2110expandableGq7TBQ4 = Modifier.INSTANCE;
                        }
                        return modifierFocusRequester.then(companionM2110expandableGq7TBQ4);
                    }

                    @Override // androidx.compose.material3.ExposedDropdownMenuBoxScope
                    /* renamed from: getAnchorType-Mg6Rgbw$material3_release */
                    public String mo2100getAnchorTypeMg6Rgbw$material3_release() {
                        return anchorTypeState.getValue().getName();
                    }

                    @Override // androidx.compose.material3.ExposedDropdownMenuBoxScope
                    public Modifier exposedDropdownSize(Modifier $this$exposedDropdownSize, final boolean matchTextFieldWidth) {
                        final MutableIntState mutableIntState = anchorWidth$delegate;
                        final MutableIntState mutableIntState2 = menuMaxHeight$delegate2;
                        return LayoutModifierKt.layout($this$exposedDropdownSize, new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1$exposedDropdownSize$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                                return m2111invoke3p2s80s(measureScope, measurable, constraints.getValue());
                            }

                            /* renamed from: invoke-3p2s80s, reason: not valid java name */
                            public final MeasureResult m2111invoke3p2s80s(MeasureScope $this$layout, Measurable measurable, long constraints) {
                                int menuWidth = ConstraintsKt.m6653constrainWidthK40F9xA(constraints, ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$5(mutableIntState));
                                long menuConstraints = Constraints.m6626copyZbe2FdA(constraints, (11 & 1) != 0 ? Constraints.m6638getMinWidthimpl(constraints) : matchTextFieldWidth ? menuWidth : Constraints.m6638getMinWidthimpl(constraints), (11 & 2) != 0 ? Constraints.m6636getMaxWidthimpl(constraints) : matchTextFieldWidth ? menuWidth : Constraints.m6636getMaxWidthimpl(constraints), (11 & 4) != 0 ? Constraints.m6637getMinHeightimpl(constraints) : 0, (11 & 8) != 0 ? Constraints.m6635getMaxHeightimpl(constraints) : ConstraintsKt.m6652constrainHeightK40F9xA(constraints, ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$8(mutableIntState2)));
                                final Placeable placeable = measurable.mo5535measureBRTryo0(menuConstraints);
                                return MeasureScope.CC.layout$default($this$layout, placeable.getWidth(), placeable.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1$exposedDropdownSize$1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                        invoke2(placementScope);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(Placeable.PlacementScope $this$layout2) {
                                        Placeable.PlacementScope.place$default($this$layout2, placeable, 0, 0, 0.0f, 4, null);
                                    }
                                }, 4, null);
                            }
                        });
                    }
                };
                focusRequester = focusRequester2;
                z = expanded;
                function12 = function1;
                $composer2.updateRememberedValue(value$iv5);
            } else {
                value$iv5 = it$iv5;
                modifier3 = modifier5;
                density = density2;
                collapsedDescription = collapsedDescription2;
                $dirty2 = $dirty;
                anchorWidth$delegate = anchorWidth$delegate2;
                function12 = function1;
                anchorTypeState = anchorTypeState2;
                expandedDescription = expandedDescription3;
                expandedDescription2 = toggleDescription;
                z = expanded;
                view = view2;
                keyboardController = keyboardController2;
                focusRequester = focusRequester2;
            }
            ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1 scope = (ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1) value$iv5;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 426351047, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changedInstance(view) | $composer2.changed(verticalMargin2);
            Object it$iv6 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv6 == Composer.INSTANCE.getEmpty()) {
                final MutableIntState anchorWidth$delegate3 = anchorWidth$delegate;
                final View view3 = view;
                Function1<LayoutCoordinates, Unit> function13 = new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                        invoke2(layoutCoordinates);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(LayoutCoordinates it) {
                        anchorCoordinates$delegate2.setValue(it);
                        anchorWidth$delegate3.setIntValue(IntSize.m6867getWidthimpl(it.mo5537getSizeYbymL2g()));
                        menuMaxHeight$delegate2.setIntValue(ExposedDropdownMenu_androidKt.calculateMaxHeight(ExposedDropdownMenu_androidKt.getWindowBounds(view3.getRootView()), ExposedDropdownMenu_androidKt.getAnchorBounds(ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$2(anchorCoordinates$delegate2)), verticalMargin2));
                    }
                };
                verticalMargin = verticalMargin2;
                anchorCoordinates$delegate = anchorCoordinates$delegate2;
                menuMaxHeight$delegate = menuMaxHeight$delegate2;
                value$iv6 = function13;
                $composer2.updateRememberedValue(value$iv6);
            } else {
                value$iv6 = it$iv6;
                verticalMargin = verticalMargin2;
                menuMaxHeight$delegate = menuMaxHeight$delegate2;
                anchorCoordinates$delegate = anchorCoordinates$delegate2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier$iv = OnGloballyPositionedModifierKt.onGloballyPositioned(modifier3, (Function1) value$iv6);
            ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3678constructorimpl($composer2);
            Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2 block$iv$iv$iv = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), block$iv$iv$iv);
            }
            Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            int i4 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -615130921, "C211@9927L9:ExposedDropdownMenu.android.kt#uh7d8r");
            function32 = function3;
            function32.invoke(scope, $composer2, Integer.valueOf(($dirty2 >> 6) & 112));
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.startReplaceGroup(426363998);
            ComposerKt.sourceInformation($composer2, "215@10008L286,215@9972L322");
            if (z) {
                ComposerKt.sourceInformationMarkerStart($composer2, 426365852, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
                boolean invalid$iv3 = $composer2.changedInstance(view) | $composer2.changed(verticalMargin);
                Object it$iv7 = $composer2.rememberedValue();
                if (invalid$iv3 || it$iv7 == Composer.INSTANCE.getEmpty()) {
                    value$iv9 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$3$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            menuMaxHeight$delegate.setIntValue(ExposedDropdownMenu_androidKt.calculateMaxHeight(ExposedDropdownMenu_androidKt.getWindowBounds(view.getRootView()), ExposedDropdownMenu_androidKt.getAnchorBounds(ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$2(anchorCoordinates$delegate)), verticalMargin));
                        }
                    };
                    $composer2.updateRememberedValue(value$iv9);
                } else {
                    value$iv9 = it$iv7;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                SoftKeyboardListener(view, density, (Function0) value$iv9, $composer2, 0);
            }
            $composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerStart($composer2, 426375501, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
            boolean invalid$iv4 = ($dirty2 & 14) == 4;
            Object it$iv8 = $composer2.rememberedValue();
            if (invalid$iv4 || it$iv8 == Composer.INSTANCE.getEmpty()) {
                value$iv7 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$4$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        if (z) {
                            focusRequester.requestFocus();
                        }
                    }
                };
                $composer2.updateRememberedValue(value$iv7);
            } else {
                value$iv7 = it$iv8;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.SideEffect((Function0) value$iv7, $composer2, 0);
            ComposerKt.sourceInformationMarkerStart($composer2, 426382265, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
            boolean invalid$iv5 = ($dirty2 & 112) == 32;
            Object it$iv9 = $composer2.rememberedValue();
            if (invalid$iv5 || it$iv9 == Composer.INSTANCE.getEmpty()) {
                value$iv8 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$5$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        function12.invoke(false);
                    }
                };
                $composer2.updateRememberedValue(value$iv8);
            } else {
                value$iv8 = it$iv9;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            BackHandlerKt.BackHandler(z, (Function0) value$iv8, $composer2, $dirty2 & 14, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox.6
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i5) {
                    ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox(z, function12, modifier4, function32, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LayoutCoordinates ExposedDropdownMenuBox$lambda$2(MutableState<LayoutCoordinates> mutableState) {
        MutableState<LayoutCoordinates> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int ExposedDropdownMenuBox$lambda$5(MutableIntState $anchorWidth$delegate) {
        MutableIntState $this$getValue$iv = $anchorWidth$delegate;
        return $this$getValue$iv.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int ExposedDropdownMenuBox$lambda$8(MutableIntState $menuMaxHeight$delegate) {
        MutableIntState $this$getValue$iv = $menuMaxHeight$delegate;
        return $this$getValue$iv.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SoftKeyboardListener(final View view, final Density density, final Function0<Unit> function0, Composer $composer, final int $changed) {
        Object value$iv;
        Composer $composer2 = $composer.startRestartGroup(-1319522472);
        ComposerKt.sourceInformation($composer2, "C(SoftKeyboardListener)P(2)240@10912L1420,240@10880L1452:ExposedDropdownMenu.android.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(view) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(density) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 256 : 128;
        }
        if (($dirty & 147) != 146 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1319522472, $dirty, -1, "androidx.compose.material3.SoftKeyboardListener (ExposedDropdownMenu.android.kt:237)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 1935200244, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(view) | (($dirty & 896) == 256);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$SoftKeyboardListener$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope $this$DisposableEffect) {
                        final ExposedDropdownMenu_androidKt$SoftKeyboardListener$1$1$listener$1 listener = new ExposedDropdownMenu_androidKt$SoftKeyboardListener$1$1$listener$1(view, function0);
                        return new DisposableEffectResult() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$SoftKeyboardListener$1$1$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                listener.dispose();
                            }
                        };
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.DisposableEffect(view, density, (Function1) value$iv, $composer2, ($dirty & 14) | ($dirty & 112));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt.SoftKeyboardListener.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    ExposedDropdownMenu_androidKt.SoftKeyboardListener(view, density, function0, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: expandable-Gq7TBQ4, reason: not valid java name */
    public static final Modifier m2110expandableGq7TBQ4(Modifier $this$expandable_u2dGq7TBQ4, final boolean expanded, final Function0<Unit> function0, final String anchorType, final String expandedDescription, final String collapsedDescription, final String toggleDescription, final SoftwareKeyboardController keyboardController) {
        return SemanticsModifierKt.semantics$default(SuspendingPointerInputFilterKt.pointerInput($this$expandable_u2dGq7TBQ4, function0, new ExposedDropdownMenu_androidKt$expandable$1(anchorType, function0, null)), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$expandable$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                invoke2(semanticsPropertyReceiver);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
                if (MenuAnchorType.m2238equalsimpl0(anchorType, MenuAnchorType.INSTANCE.m2244getSecondaryEditableMg6Rgbw())) {
                    SemanticsPropertiesKt.m5975setRolekuIjeqM($this$semantics, Role.INSTANCE.m5956getButtono7Vup1c());
                    SemanticsPropertiesKt.setStateDescription($this$semantics, expanded ? expandedDescription : collapsedDescription);
                    SemanticsPropertiesKt.setContentDescription($this$semantics, toggleDescription);
                } else {
                    SemanticsPropertiesKt.m5975setRolekuIjeqM($this$semantics, Role.INSTANCE.m5958getDropdownListo7Vup1c());
                }
                final Function0<Unit> function02 = function0;
                final String str = anchorType;
                final SoftwareKeyboardController softwareKeyboardController = keyboardController;
                SemanticsPropertiesKt.onClick$default($this$semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$expandable$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Boolean invoke() {
                        SoftwareKeyboardController softwareKeyboardController2;
                        function02.invoke();
                        if (MenuAnchorType.m2238equalsimpl0(str, MenuAnchorType.INSTANCE.m2242getPrimaryEditableMg6Rgbw()) && (softwareKeyboardController2 = softwareKeyboardController) != null) {
                            softwareKeyboardController2.show();
                        }
                        return true;
                    }
                }, 1, null);
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int calculateMaxHeight(Rect windowBounds, Rect anchorBounds, int verticalMargin) {
        int availableHeight;
        if (anchorBounds == null) {
            return 0;
        }
        float marginedWindowTop = windowBounds.getTop() + verticalMargin;
        float marginedWindowBottom = windowBounds.getBottom() - verticalMargin;
        if (anchorBounds.getTop() > windowBounds.getBottom() || anchorBounds.getBottom() < windowBounds.getTop()) {
            float heightAbove = marginedWindowBottom - marginedWindowTop;
            availableHeight = MathKt.roundToInt(heightAbove);
        } else {
            float heightAbove2 = anchorBounds.getTop() - marginedWindowTop;
            float heightBelow = marginedWindowBottom - anchorBounds.getBottom();
            availableHeight = MathKt.roundToInt(Math.max(heightAbove2, heightBelow));
        }
        return Math.max(availableHeight, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Rect getWindowBounds(View $this$getWindowBounds) {
        android.graphics.Rect it = new android.graphics.Rect();
        $this$getWindowBounds.getWindowVisibleDisplayFrame(it);
        return RectHelper_androidKt.toComposeRect(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Rect getAnchorBounds(LayoutCoordinates $this$getAnchorBounds) {
        return $this$getAnchorBounds == null ? Rect.INSTANCE.getZero() : RectKt.m3985Recttz77jQw(LayoutCoordinatesKt.positionInWindow($this$getAnchorBounds), IntSizeKt.m6879toSizeozmzZPI($this$getAnchorBounds.mo5537getSizeYbymL2g()));
    }
}
